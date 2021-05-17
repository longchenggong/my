package com.ello.base.designpatterns.one.decorator;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/299:58
 */
public interface DataSource {
    void writeData(String data);
    String readData();
}
