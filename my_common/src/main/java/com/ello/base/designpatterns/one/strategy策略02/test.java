package com.ello.base.designpatterns.one.strategy策略02;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/299:09
 */
public class test {

    private static PayStrategy strategy;
    public static void main(String[] args) {
        strategy=new PayByPayPal();
        strategy.pay(10);
    }
}
