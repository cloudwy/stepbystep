package com.wy.stepbystep;

import io.micronaut.context.BeanContext;
import io.micronaut.runtime.Micronaut;


public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
        BeanContext beanContext = BeanContext.run();
        DomainRepository domainRepository1 = beanContext.getBean(DomainRepository.class);
        DomainRepository domainRepository2 = beanContext.getBean(DomainRepository.class);
        System.out.println(domainRepository1);
        System.out.println(domainRepository2);
    }
}