package com.ello.base.designpatterns.one.observer;

import java.io.File;

/**
 * @author longchenggong
 * @Description: 收到通知后发邮件
 * @date 2021/4/715:21
 */
public class EmailNotificationListener implements EventListener{
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("email:"+email+" event:"+eventType+" file:"+file);
    }
}
