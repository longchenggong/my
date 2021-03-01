package com.ello.entry;

import com.ello.Imp.CombustionEngine;
import com.ello.inter.Engine;

public class CombustionCar extends Car{
    public CombustionCar() {
        super(new CombustionEngine());
    }


    public static void main(String[] args) {
        Car car=new CombustionCar();
        car.start();
    }
}
