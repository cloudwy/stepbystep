package com.wy.stepbystep.refreshable;

import io.micronaut.runtime.context.scope.Refreshable;
import jakarta.annotation.PostConstruct;

import java.util.Random;

@Refreshable
public class RefreshableSeed {
    private int seed;

    @PostConstruct
    public void init(){
        seed = new Random().nextInt();
    }

    public int latestSeed(){
        return seed;
    }
}
