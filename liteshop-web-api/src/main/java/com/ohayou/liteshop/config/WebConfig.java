package com.ohayou.liteshop.config;

import com.ohayou.liteshop.interceptor.IdempotentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liyan
 * @date 2021/2/23 下午9:39
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private IdempotentInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
