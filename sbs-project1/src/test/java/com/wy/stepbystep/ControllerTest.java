package com.wy.stepbystep;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class ControllerTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    DomainRepository domainRepository;

    @BeforeEach
    void setup(){
        domainRepository.clearAllDomains();
        domainRepository.addNewDomain(1, "salzburg-ag");
        domainRepository.addNewDomain(2, "google");
        domainRepository.addNewDomain(3, "yahoo");
    }

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testGetAllDomains(){
        assertEquals(3, domainRepository.getDomains().size());
    }

    @Test
    void testAddNewSymbol(){
        domainRepository.addNewDomain(4, "deutschebank");
//        Map<Integer, String> relDomains = new HashMap<>(domainService.getDomains());
//        for (Map.Entry<Integer, String> entry : relDomains.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }
    assertEquals(4, domainRepository.getDomains().size());
    }

    @Test
    void testConvertWithStream(){
        String str = domainRepository.convertToString();
        assertEquals("{1=salzburg-ag,2=google,3=yahoo}", str);
    }
}
