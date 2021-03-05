package com.ello.entity;

import com.ello.inter.Engine;

public class Car {
    private Engine engine;

    public void start(){
        engine.turnOn();
    }

    public Car(Engine engine) {
        this.engine = engine;
    }
}
