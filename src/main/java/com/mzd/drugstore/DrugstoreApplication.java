package com.mzd.drugstore;

import com.mzd.drugstore.bean.generator.Product;
import com.mzd.drugstore.filter.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import redis.clients.jedis.JedisPoolConfig;

import java.nio.charset.Charset;

@SpringBootApplication
@MapperScan(basePackages = "com.mzd.drugstore.mapper")
//扫描监听
@ServletComponentScan
@EnableAutoConfiguration
//支持事务
@EnableTransactionManagement
public class DrugstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugstoreApplication.class, args);
    }

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
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return redisTemplate;
    }


}
