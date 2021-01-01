package com.ohayou.liteshop.es.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.es.EsGoods;
import com.ohayou.liteshop.es.repository.EsGoodsRepository;
import com.ohayou.liteshop.service.MallBrandService;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import org.apache.commons.lang3.StringUtils;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;


import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liyan
 * @date 2020/12/16 下午9:47
 */
@Service
public class EsGoodsServiceImpl implements EsGoodsService {
    @Autowired
    EsGoodsRepository esGoodsRepository;

    @Autowired
    MallBrandService brandService;

    @Autowired
    MallCategoryService categoryService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    @Qualifier("elasticsearchTemplate")
    ElasticsearchRestTemplate esTemplate;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(EsGoodsServiceImpl.class);

    final String INDEX = EsGoods.class.getSimpleName().toLowerCase();

//    @PostConstruct
//    public void init() {
//        IndexCoordinates indexCoordinates = IndexCoordinates.of(INDEX);
//        IndexOperations indexOperations = esTemplate.indexOps(indexCoordinates);
//        if (!indexOperations.exists()) {
//            indexOperations.create();
//            this.importData();
//        }
//    }

    @Override
    public boolean createIndex(String indexName) {
        IndexCoordinates indexCoordinates = IndexCoordinates.of(indexName);
        IndexOperations indexOperations = esTemplate.indexOps(indexCoordinates);
        return indexOperations.create();
    }

    @Override
    public List<EsGoods> searchGoodsPageBKeyWord(String key, PageRequest pageRequest) {

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //搜索条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (StringUtils.isNotBlank(key)) {
            boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.must(QueryBuilders.multiMatchQuery(key, "name", "title"));
        }
        boolQueryBuilder.must(QueryBuilders.termQuery("status", 1))
                .must(QueryBuilders.termQuery("deleted",0));

        NativeSearchQuery query = queryBuilder
                .withQuery(boolQueryBuilder)
                .withPageable(pageRequest)
                .withSort(SortBuilders.scoreSort().order(SortOrder.DESC))
                .build();

        LOGGER.info("DSL:{}", query.getQuery().toString());

        List<SearchHit<EsGoods>> searchHits = esTemplate.search(query, EsGoods.class).getSearchHits();
        return searchHits.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());

    }


    @Override
    public void importData() {
        List<MallGoodsSpu> list = goodsSpuService.list(new LambdaQueryWrapper<MallGoodsSpu>()
                .eq(MallGoodsSpu::getDeleted, 0));
        List<EsGoods> collect = list.stream()
                .map(mallGoodsSpu -> {
                    EsGoods esGoods = new EsGoods();
                    BeanUtils.copyProperties(mallGoodsSpu, esGoods);
                    esGoods.setBrandName(brandService.getById(mallGoodsSpu.getBrandId()).getName());
                    esGoods.setCategoryName(categoryService.getById(mallGoodsSpu.getCategoryId()).getName());
                    return esGoods;
                }).collect(Collectors.toList());
        esGoodsRepository.saveAll(collect);

    }

}

