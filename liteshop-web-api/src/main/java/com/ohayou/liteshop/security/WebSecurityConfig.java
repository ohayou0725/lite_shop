package com.ohayou.liteshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * @author liyan
 * @date 2020/11/23 下午9:27
 */
@EnableWebSecurity
@Configuration
@PropertySource("classpath:loginRequiredUrls.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${required.urls}")
    private String urls;

    @Autowired
    CorsConfigurationSource configurationSource;

    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors()
                .configurationSource(configurationSource)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(urls)
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint);

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberUserDetails).passwordEncoder(passwordEncoder);
//    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}
