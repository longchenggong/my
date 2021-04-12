package com.ello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/911:24
 */
@AllArgsConstructor
@Data
public class Cat {
    private String name;
    private Integer age;


    public void printName(){
        System.out.println("name:"+name);
    }

}
