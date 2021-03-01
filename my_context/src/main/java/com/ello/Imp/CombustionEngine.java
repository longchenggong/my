package com.ello.Imp;

import com.ello.inter.Engine;

public class CombustionEngine implements Engine {
    @Override
    public void turnOn() {
        System.out.println("燃油引擎启动");
    }

}
