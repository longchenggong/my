package com.ello.base.designpatterns.one.strategy策略02;

/**
 * @author longchenggong
 * @Description: 通用接口
 * @date 2021/3/299:10
 */
public interface PayStrategy {
    Boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
