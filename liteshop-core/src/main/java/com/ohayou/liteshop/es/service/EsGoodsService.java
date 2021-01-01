package com.ohayou.liteshop.es.service;

import com.ohayou.liteshop.es.EsGoods;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author liyan
 * @date 2020/12/17 下午9:20
 */
public interface EsGoodsService {
    void importData();


    boolean createIndex(String indexName);

    List<EsGoods> searchGoodsPageBKeyWord(String key, PageRequest pageRequest);
}
