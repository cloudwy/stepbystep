package com.wy.stepbystep;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SbsProject1Test {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    DomainService domainService;

    @BeforeEach
    void setup(){
        domainService.clearAllDomains();
        domainService.addNewDomain(1, "salzburg-ag");
        domainService.addNewDomain(2, "google");
        domainService.addNewDomain(3, "yahoo");
    }

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testGetAllDomains(){
        assertEquals(3, domainService.getDomains().size());
    }

    @Test
    void testAddNewSymbol(){
        domainService.addNewDomain(4, "deutschebank");
//        Map<Integer, String> relDomains = new HashMap<>(domainService.getDomains());
//        for (Map.Entry<Integer, String> entry : relDomains.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }
    assertEquals(4, domainService.getDomains().size());
    }

    @Test
    void testConvertWithStream(){
        String str = domainService.convertToString();
        assertEquals("{1=salzburg-ag,2=google,3=yahoo}", str);
    }
}
