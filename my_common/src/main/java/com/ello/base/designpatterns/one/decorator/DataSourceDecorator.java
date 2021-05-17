package com.ello.base.designpatterns.one.decorator;

/**
 * @author longchenggong
 * @Description: 基础装饰类
 * @date 2021/3/2910:09
 */
public class DataSourceDecorator implements DataSource{
    private DataSource wrapper;

    public DataSourceDecorator(DataSource wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);

    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}
