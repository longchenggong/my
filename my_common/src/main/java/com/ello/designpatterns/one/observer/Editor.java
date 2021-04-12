package com.ello.designpatterns.one.observer;

import java.io.File;

/**
 * @author longchenggong
 * @Description: 具体发布者
 * @date 2021/4/715:36
 */
public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath){
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile(){
        events.notify("save", file);
    }
}
