package com.ello.Imp;

import com.ello.inter.Engine;

public class ElectricEngine implements Engine {
    @Override
    public void turnOn() {
        System.out.println("电动引擎启动");
    }
}
