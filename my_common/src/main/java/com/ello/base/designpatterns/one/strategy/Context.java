package com.ello.base.designpatterns.one.strategy;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/2617:55
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Integer excute(Integer a,Integer b){
        return strategy.execute(a,b);
    }
}
