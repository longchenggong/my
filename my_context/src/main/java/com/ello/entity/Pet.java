package com.ello.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/515:02
 */
@ConfigurationProperties(prefix = "pet")
@Data
@ToString
@Component
@Primary
public class Pet {

    private String name;
    private Integer weight;
    private Map<String,String> map;
    private List<String> list;
    private Cat cat;

}
