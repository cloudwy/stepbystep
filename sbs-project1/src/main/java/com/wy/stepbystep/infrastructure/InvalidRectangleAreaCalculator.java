package com.wy.stepbystep.infrastructure;

import io.micronaut.context.annotation.Replaces;
import jakarta.inject.Singleton;

@Singleton
@Replaces(RectangleAreaCalculator.class)
public class InvalidRectangleAreaCalculator extends RectangleAreaCalculator {
    @Override
    public double calculate(double a, double b){
        return a - b;
    }
}
