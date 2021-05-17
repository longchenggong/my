package com.ello.base.designpatterns.one.strategy;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/2617:54
 */
public class ConcreteStrategySubtract implements Strategy{
    public Integer execute(Integer a, Integer b) {
        return a-b;
    }
}
