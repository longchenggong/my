package com.ello.base.designpatterns.one.strategy;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/2617:53
 */
public class ConcreteStrategyAdd implements Strategy{
    public Integer execute(Integer a, Integer b) {
        return a+b;
    }
}
