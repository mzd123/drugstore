package com.mzd.drugstore.config;

import com.mzd.drugstore.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebBean {
    /**
     * xss过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

//============================================redis=====================================================
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory j = new JedisConnectionFactory();
        //绑定ip
        j.setHostName("localhost");
        //监听端口
        j.setPort(6379);
        //客户端闲置多少时间后断开连接
        j.setTimeout(2000);
        j.setUsePool(true);
        j.setUseSsl(false);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        j.setPoolConfig(jedisPoolConfig);
        j.setConvertPipelineAndTxResults(true);
        return j;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer(Charset.forName("UTF8")));
        //  http://stamen.iteye.com/blog/1907984
        // redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return redisTemplate;
    }
}
