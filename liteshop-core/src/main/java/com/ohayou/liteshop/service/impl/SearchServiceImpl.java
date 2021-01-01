package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.HotSearchKeyWordsKey;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.es.EsGoods;
import com.ohayou.liteshop.es.service.EsGoodsService;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.SearchService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.HotGoodsVo;
import com.ohayou.liteshop.vo.HotSearchKeyWordsVo;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author liyan
 * @date 2020/12/5 下午9:28
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    RedisService redisService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    EsGoodsService esGoodsService;

    public static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);

    /**
     * 从Redis里取出前几名热搜词
     * @return 热搜词列表
     */
    @Override
    public List<HotSearchKeyWordsVo> getHotSearchKeyWords() {
        List<ZSetOperations.TypedTuple<Object>> typedTuples = redisService.zReverseRange(new HotSearchKeyWordsKey().getPrefix());
        if (null != typedTuples) {
           return typedTuples.stream()
                    .map(typedTuple -> {
                        HotSearchKeyWordsVo searchKeyWordsVo = new HotSearchKeyWordsVo();
                        searchKeyWordsVo.setText(String.valueOf(typedTuple.getValue()));
                        searchKeyWordsVo.setScore(typedTuple.getScore());
                        return searchKeyWordsVo;
                    }).collect(Collectors.toList());

        }
        return null;
    }

    /**
     * 根据关键字查询商品列表
     * @param page 分页对象
     * @param key 关键字
     * @return 商品列表
     */
    @Override
    public PageUtils searchGoodsListByKeyWords(IPage<MallGoodsSpu> page, String key) {
        if (StringUtils.isBlank(key)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        LambdaUpdateWrapper<MallGoodsSpu> wrapper = new LambdaUpdateWrapper<>();
        wrapper.like(MallGoodsSpu::getName,key);
        goodsSpuService.page(page,wrapper);

        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<HotGoodsVo> collect = page.getRecords().stream()
                    .map(mallGoodsSpu -> {
                        HotGoodsVo hotGoodsVo = new HotGoodsVo();
                        hotGoodsVo.setTitle(mallGoodsSpu.getTitle());
                        hotGoodsVo.setDiscountPrice(mallGoodsSpu.getDiscountPrice());
                        hotGoodsVo.setPrice(mallGoodsSpu.getPrice());
                        hotGoodsVo.setImg(mallGoodsSpu.getTitleImg());
                        hotGoodsVo.setDesc(mallGoodsSpu.getBrief());
                        hotGoodsVo.setGoodsId(mallGoodsSpu.getId());
                        return hotGoodsVo;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 将关键字词频存入到redis,如果已存在关键字则对该关键字分数自增
     * @param key 关键字
     */
    @Override
    public void saveHotSearchKeyCount(String key) {
        HotSearchKeyWordsKey hotSearchKeyWordsKey = new HotSearchKeyWordsKey();
        redisService.zIncrBy(hotSearchKeyWordsKey.getPrefix(),1d,key);

    }

    /**
     * 根据三级分类ID分页查询商品
     * @param page
     * @param categoryId
     * @return
     */
    @Override
    public PageUtils searchGoodsListByCategory(IPage<MallGoodsSpu> page, Long categoryId) {
        LambdaQueryWrapper<MallGoodsSpu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MallGoodsSpu::getCategoryId,categoryId);

        goodsSpuService.page(page,wrapper);
        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<HotGoodsVo> collect = page.getRecords().stream()
                    .map(mallGoodsSpu -> {
                        HotGoodsVo hotGoodsVo = new HotGoodsVo();
                        hotGoodsVo.setTitle(mallGoodsSpu.getTitle());
                        hotGoodsVo.setDiscountPrice(mallGoodsSpu.getDiscountPrice());
                        hotGoodsVo.setPrice(mallGoodsSpu.getPrice());
                        hotGoodsVo.setImg(mallGoodsSpu.getTitleImg());
                        hotGoodsVo.setDesc(mallGoodsSpu.getBrief());
                        hotGoodsVo.setGoodsId(mallGoodsSpu.getId());
                        return hotGoodsVo;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }

        return pageUtils;
    }

    /**
     * 使用es根据搜索关键字查询商品
     * @param key
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<HotGoodsVo> searchGoodsByKeyWords(String key, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        List<EsGoods> esGoods = esGoodsService.searchGoodsPageBKeyWord(key, pageRequest);
        return esGoods.stream()
                .map(goods -> {
                    HotGoodsVo hotGoodsVo = new HotGoodsVo();
                    hotGoodsVo.setGoodsId(goods.getId());
                    hotGoodsVo.setImg(goods.getTitleImg());
                    BeanUtils.copyProperties(goods, hotGoodsVo);
                    return hotGoodsVo;
                }).collect(Collectors.toList());

    }

}
