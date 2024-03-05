package com.wy.stepbystep.threadlocal;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class FirstService {
    @Inject
    Mediator mediator;

    public void setMessage(String message) {
        mediator.setMessage(message);
    }

    public String getMessage(){
        return mediator.getMessage();
    }

}
