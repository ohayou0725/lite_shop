package com.ohayou.liteshop.es.repository;

import com.ohayou.liteshop.es.EsGoods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author liyan
 * @date 2020/12/15 下午10:10
 */
@Repository
public interface EsGoodsRepository extends ElasticsearchRepository<EsGoods,Long> {

}
