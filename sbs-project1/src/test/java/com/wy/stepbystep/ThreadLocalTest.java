package com.wy.stepbystep;

import com.wy.stepbystep.threadlocal.FirstService;
import com.wy.stepbystep.threadlocal.LastService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@MicronautTest
public class ThreadLocalTest {
    @Inject
    FirstService firstService;
    @Inject
    LastService lastService;

    @Test
    public void testThreadLocalScope(){
        final Random r = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 3; i++){
            executor.execute(() -> {
                String message = "message" + r.nextInt(10000);
                System.out.println("current Thread: " + Thread.currentThread().getName() + " " + "message: " + message);
                firstService.setMessage(message);
                System.out.println("current Thread: " + Thread.currentThread().getName() + " " + "message of firstService: " + firstService.getMessage());
                System.out.println("current Thread: " + Thread.currentThread().getName() + " " + "message of lastService: " + lastService.getMessage());
                Assertions.assertEquals(message, lastService.getMessage());
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        System.out.println("Done!");
    }


}
