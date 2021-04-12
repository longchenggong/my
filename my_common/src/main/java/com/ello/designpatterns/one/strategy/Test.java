package com.ello.designpatterns.one.strategy;

/**
 * @author longchenggong
 * @Description: 策略
 * @date 2021/3/2617:50
 */
public class Test {

    public static void main(String[] args) {
        Context context=new Context(new ConcreteStrategyAdd());
        System.out.println(context.excute(2, 3));

    }
}
