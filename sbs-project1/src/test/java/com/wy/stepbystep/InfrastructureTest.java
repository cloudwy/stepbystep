package com.wy.stepbystep;

import com.wy.stepbystep.infrastructure.RectangleAreaCalculator;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class InfrastructureTest {
    @Inject
    RectangleAreaCalculator rectangleAreaCalculator;

    @Test
    void infrastructureBeanDoesNotGetPlaced(){
        Assertions.assertInstanceOf(RectangleAreaCalculator.class, rectangleAreaCalculator);
        Assertions.assertEquals(20, rectangleAreaCalculator.calculate(4, 5));
    }
}
