package com.mzd.drugstore.config;

import com.mzd.drugstore.filter.MyInterceptor;
import com.mzd.drugstore.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import redis.clients.jedis.JedisPoolConfig;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

//第二个拦截器
//    @Bean
//    public XSSInterceptor xssInterceptor() {
//        return new XSSInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(xssInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


}
