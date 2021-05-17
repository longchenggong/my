package com.ello.base.designpatterns.one.observer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author longchenggong
 * @Description:基础发布者
 * @date 2021/4/715:26
 */
public class EventManager {
    Map<String, List<EventListener>> listeners=new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * 订阅
     * @param eventType
     * @param listener
     */
    public void subscribe(String eventType,EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * 退订
     * @param eventType
     * @param listener
     */
    public void unsubscribe(String eventType,EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * 通知
     * @param eventType
     * @param file
     */
    public void notify(String eventType, File file){
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
