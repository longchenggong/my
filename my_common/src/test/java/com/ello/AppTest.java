package com.ello;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class AppTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(jdbcTemplate);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user ");
        System.out.println("maps = " + maps);
        log.info("数据源{}",dataSource.getClass());

    }
    @Test
    public void redisTest(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("String_1","work111");
        log.info("{}",redisTemplate.getClientList());

        log.info("jedis或lettuce:{}",redisConnectionFactory.getClass());
    }
}
