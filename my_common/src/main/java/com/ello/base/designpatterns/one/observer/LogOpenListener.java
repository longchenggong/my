package com.ello.base.designpatterns.one.observer;

import java.io.File;

/**
 * @author longchenggong
 * @Description: 收到通知后记录日志
 * @date 2021/4/715:23
 */
public class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("记录文件："+log +" evenType:"+eventType+ " sdf:"+file.getName());
    }
}
