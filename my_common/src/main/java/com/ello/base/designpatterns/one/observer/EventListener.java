package com.ello.base.designpatterns.one.observer;

import java.io.File;

/**
 * @author longchenggong
 * @Description: 通用观察者接口
 * @date 2021/4/715:20
 */
public interface EventListener {
    void update(String eventType, File file);
}
