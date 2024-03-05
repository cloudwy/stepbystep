package com.wy.stepbystep;

import io.micronaut.context.BeanContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


@MicronautTest
class SingletonTest {
    @Test
    void SingletonOrPrototype() {
        BeanContext beanContext = BeanContext.run();
        DomainRepository domainRepository1 = beanContext.getBean(DomainRepository.class);
        DomainRepository domainRepository2 = beanContext.getBean(DomainRepository.class);
        Annotation[] ann = domainRepository1.getClass().getAnnotations();
        if(ann.length != 0){
            for(Annotation val: ann){
                System.out.println("Annotation: " + val.toString());
            }
        }
        assertEquals(domainRepository1, domainRepository2);
    }
}
