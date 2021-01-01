package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.HotGoodsVo;
import com.ohayou.liteshop.vo.HotSearchKeyWordsVo;

import java.util.List;

/**
 * @author liyan
 * @date 2020/12/5 下午9:28
 */
public interface SearchService {
    List<HotSearchKeyWordsVo> getHotSearchKeyWords();

    PageUtils searchGoodsListByKeyWords(IPage<MallGoodsSpu> page, String key);

    void saveHotSearchKeyCount(String key);

    PageUtils searchGoodsListByCategory(IPage<MallGoodsSpu> page, Long categoryId);

    List<HotGoodsVo> searchGoodsByKeyWords(String key,int page, int size);
}
