package com.wy.stepbystep.threadlocal;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class LastService {
    @Inject
    Mediator mediator;

    public String getMessage() {
        return mediator.getMessage();
    }
}
