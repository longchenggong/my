package com.ello.entity;

import com.ello.Imp.CombustionEngine;

public class CombustionCar extends Car{
    public CombustionCar() {
        super(new CombustionEngine());
    }

}
