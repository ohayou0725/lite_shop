package com.ohayou.liteshop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author liyan
 * @date 2020/11/23 下午9:27
 */
@SpringBootApplication
@EnableElasticsearchRepositories
public class WebApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApiApplication.class,args);
    }
}
