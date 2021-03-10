package com.ello.config;

import com.ello.entity.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/514:05
 */
@Configuration
public class TestConfig {

    @Bean
    public Pet get(){
        return new Pet();
    }
}
