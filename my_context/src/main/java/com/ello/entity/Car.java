package com.ello.entity;

import com.ello.inter.Engine;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Data
public class Car {

    private Engine engine;

    private String name;

    public void start(){
        engine.turnOn();
    }

    public Car(Engine engine) {
        this.engine = engine;
    }
}
