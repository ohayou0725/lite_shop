package com.ohayou.liteshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liyan
 * @date 2021/1/14 下午9:05
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        //根据cpu线程数创建适合线程
        int cpu = Runtime.getRuntime().availableProcessors();
        return  new ThreadPoolExecutor(cpu, 2 * cpu, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    }
}
