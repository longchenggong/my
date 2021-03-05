package com.ello.entity;

import com.ello.Imp.CombustionEngine;

public class CombustionCar extends Car{
    public CombustionCar() {
        super(new CombustionEngine());
    }


    public static void main(String[] args) {
        Car car=new CombustionCar();
        car.start();
    }
}
