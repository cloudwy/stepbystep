package com.wy.stepbystep.infrastructure;

import io.micronaut.context.annotation.Infrastructure;

@Infrastructure
public class RectangleAreaCalculator {
    public double calculate(double a, double b){
        return a * b;
    }
}
