package com.ohayou.liteshop.es.config;


import org.springframework.context.annotation.Configuration;


/**
 * @author liyan
 * @date 2020/12/19 上午11:59
 */
@Configuration
public class ElasticsearchConfig {

//    @Bean
//    public RestHighLevelClient restHighLevelClient() {
//        return new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("localhost",9200,"http")
//                )
//        );
//    }
//
//    @Bean(name = "elasticsearchTemplate")
//    public ElasticsearchRestTemplate elasticsearchTemplate(RestHighLevelClient restHighLevelClient, ElasticsearchConverter converter
//    , ResultsMapper resultsMapper) {
//        return new ElasticsearchRestTemplate(restHighLevelClient,converter,resultsMapper);
//    }
}
