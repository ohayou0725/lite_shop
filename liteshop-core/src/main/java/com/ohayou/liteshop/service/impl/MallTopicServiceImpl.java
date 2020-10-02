package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.TopicDto;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.entity.MallTopic;
import com.ohayou.liteshop.dao.MallTopicMapper;
import com.ohayou.liteshop.entity.MallTopicGoods;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MallTopicGoodsService;
import com.ohayou.liteshop.service.MallTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 专题表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallTopicServiceImpl extends ServiceImpl<MallTopicMapper, MallTopic> implements MallTopicService {

    @Autowired
    MallTopicGoodsService topicGoodsService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    /**
     * 条件查询主题列表
     * @param topicDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(TopicDto topicDto, IPage<MallTopic> page) {
        LambdaQueryWrapper<MallTopic> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(topicDto.getTitle()),MallTopic::getTitle,topicDto.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(topicDto.getSubtitle()),MallTopic::getSubtitle,topicDto.getSubtitle());
        queryWrapper.eq(null != topicDto.getIsShow(),MallTopic::getIsShow,topicDto.getIsShow());

        //判断查询条件中时候有品牌查询
        if (null != topicDto.getBrandId() && topicDto.getBrandId() > 0) {
            queryWrapper.eq(MallTopic::getBrandId,topicDto.getBrandId());
        }

        this.page(page,queryWrapper);
        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<TopicDto> collect = page.getRecords().stream()
                    .map(mallTopic -> {
                        TopicDto newTopicDto = new TopicDto();
                        BeanUtils.copyProperties(mallTopic, newTopicDto);
                        return newTopicDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 更改主题上线状态
     * @param topicDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeShow(TopicDto topicDto) {
        MallTopic topic = this.getById(topicDto.getId());
        if (null == topic) {
            throw new GlobalException(ErrorCodeMsg.TOPIC_NOT_EXIST);
        }

        topic.setIsShow(topicDto.getIsShow());
        return this.updateById(topic);
    }

    /**
     * 添加专题
     * @param topicDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addTopic(TopicDto topicDto) {

        MallTopic newTopic = new MallTopic();
        BeanUtils.copyProperties(topicDto,newTopic);

        boolean save = this.save(newTopic);
        if (save && CollectionUtil.isNotEmpty(topicDto.getGoodsList())) {
            List<MallGoodsSpu> goodsList = topicDto.getGoodsList();
            List<Long> goodsIdList = goodsList.stream()
                    .map(MallGoodsSpu::getId)
                    .collect(Collectors.toList());

            List<MallTopicGoods> collect = goodsIdList.stream()
                    .map(goodsId -> {
                        MallTopicGoods mallTopicGoods = new MallTopicGoods();
                        mallTopicGoods.setGoodsId(goodsId);
                        mallTopicGoods.setTopicId(newTopic.getId());
                        return mallTopicGoods;
                    }).collect(Collectors.toList());
            boolean result = topicGoodsService.saveBatch(collect);
            if (!result) {
                throw new GlobalException(ErrorCodeMsg.TOPIC_ADD_ERROR);
            }
            return true;
        }
        return save;
    }

    /**
     * 获取专题下所有商品
     * @param topicId
     * @return
     */
    @Override
    public List<MallGoodsSpu> getGoodsList(Long topicId) {
        if (null == topicId || topicId < 1) {
            return null;
        }
        return goodsSpuService.goodsListByTopicId(topicId);
    }

    /**
     * 添加专题相关商品
     * @param topicDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addTopicGoods(TopicDto topicDto) {
        Long id = topicDto.getId();
        MallTopic topic = this.getById(id);

        if (null == topic) {
            throw new GlobalException(ErrorCodeMsg.TOPIC_NOT_EXIST);
        }
        List<MallGoodsSpu> goodsList = topicDto.getGoodsList();
        List<Long> goodsIdList = goodsList.stream()
                .map(MallGoodsSpu::getId).collect(Collectors.toList());
        //获取已添加商品列表，判断是否已经添加
        List<MallTopicGoods> list = topicGoodsService.list(new LambdaQueryWrapper<MallTopicGoods>()
                .eq(MallTopicGoods::getTopicId, id));
        if (CollectionUtil.isNotEmpty(list)) {
            List<Long> collect = list.stream().map(MallTopicGoods::getGoodsId).collect(Collectors.toList());
            //求两个集合的交集
            if (CollectionUtil.isNotEmpty(CollectionUtil.intersection(goodsIdList,collect))) {
                throw new GlobalException(ErrorCodeMsg.TOPIC_GOODS_EXIST);
            }
        }


        List<MallTopicGoods> collect = goodsIdList.stream()
                .map(goodsId -> {
                    MallTopicGoods mallTopicGoods = new MallTopicGoods();
                    mallTopicGoods.setTopicId(id);
                    mallTopicGoods.setGoodsId(goodsId);
                    return mallTopicGoods;
                }).collect(Collectors.toList());
        if (topicGoodsService.saveBatch(collect)) {
            MallTopic mallTopic = new MallTopic();
            mallTopic.setId(id);
            BigDecimal minPrice = getMinPrice(id);
            mallTopic.setPrice(minPrice);

            return this.updateById(mallTopic);
        }
        return false;
    }


    private BigDecimal getMinPrice(Long topicId) {
        List<MallGoodsSpu> goodsList = this.getGoodsList(topicId);
        MallGoodsSpu goodsSpu = goodsList.stream()
                .min(Comparator.comparing(MallGoodsSpu::getDiscountPrice)).get();
        return goodsSpu.getDiscountPrice();
    }
    /**
     * 移除主题商品
     * @param topicDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteGoods(TopicDto topicDto) {
        Long id = topicDto.getId();
        MallTopic topic = this.getById(id);

        if (null == topic) {
            throw new GlobalException(ErrorCodeMsg.TOPIC_NOT_EXIST);
        }
        MallGoodsSpu goodsSpu = topicDto.getGoodsList().get(0);
        if (null == goodsSpu.getId()) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallTopicGoods mallTopicGoods = new MallTopicGoods();
        mallTopicGoods.setGoodsId(goodsSpu.getId());
        mallTopicGoods.setTopicId(id);
        boolean remove = topicGoodsService.remove(new LambdaQueryWrapper<MallTopicGoods>()
                .eq(MallTopicGoods::getGoodsId, mallTopicGoods.getGoodsId())
                .eq(MallTopicGoods::getTopicId, mallTopicGoods.getTopicId()));
        if (remove) {
            MallTopic mallTopic = new MallTopic();
            mallTopic.setId(id);
            mallTopic.setPrice(getMinPrice(id));
            return this.updateById(mallTopic);
        }
        return false;
    }

    /**
     * 删除专题
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteTopic(Long id) {
        MallTopic topic = this.getById(id);
        if (null == topic) {
            throw new GlobalException(ErrorCodeMsg.TOPIC_NOT_EXIST);
        }
        List<MallGoodsSpu> goodsList = this.getGoodsList(id);

        //删除专题
        boolean remove = this.removeById(topic);
        if (remove && CollectionUtil.isNotEmpty(goodsList)) {
            //删除专题下相关商品
            List<Long> collect = goodsList.stream()
                    .map(MallGoodsSpu::getId).collect(Collectors.toList());
            return topicGoodsService.removeByIds(collect);
        }
        return remove;
    }

    /**
     * 新增或更新专题详情
     * @param topicDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrUpdateContent(TopicDto topicDto) {
        MallTopic topic = this.getById(topicDto.getId());
        if (null == topic) {
            throw new GlobalException(ErrorCodeMsg.TOPIC_NOT_EXIST);
        }

        MallTopic newTopic = new MallTopic();
        newTopic.setId(topic.getId());
        newTopic.setContent(topicDto.getContent());
        return this.saveOrUpdate(newTopic);
    }

    /**
     * 更新专题基本信息
     * @param topicDto
     * @return
     */
    @Override
    public boolean updateTopic(TopicDto topicDto) {
        MallTopic topic = this.getById(topicDto.getId());
        if (null == topic) {
            throw new GlobalException(ErrorCodeMsg.TOPIC_NOT_EXIST);
        }
        topic.setTitle(topicDto.getTitle());
        topic.setSubtitle(topicDto.getSubtitle());
        topic.setImgs(topicDto.getImgs());
        topic.setSort(topicDto.getSort());
        return this.updateById(topic);
    }
}
