package com.wy.stepbystep.threadlocal;

import io.micronaut.runtime.context.scope.ThreadLocal;

@ThreadLocal
public class Mediator {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
