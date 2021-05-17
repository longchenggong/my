package com.ello.base.designpatterns.one.observer;

/**
 * @author longchenggong
 * @Description:
 *
 * 察者模式在文本编辑器的对象之间建立了间接的合作关系。
 * 每当 编辑器  （Editor） 对象改变时， 它都会通知其订阅者。
 * 邮件通知监听器  （Email­Notification­Listener） 和 日志开启监听器  （Log­Open­Listener）
 * 都将通过执行其基本行为来对这些通知做出反应。
 *
 * @date 2021/4/715:39
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("a"));
        editor.events.subscribe("save", new EmailNotificationListener("qq.com"));

        editor.openFile("test.txt");
        editor.saveFile();

    }
}
