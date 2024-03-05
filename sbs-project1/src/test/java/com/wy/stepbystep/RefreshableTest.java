// https://softwaremill.com/introduction-to-micronaut-ioc-basics/

package com.wy.stepbystep;

import com.wy.stepbystep.refreshable.RefreshableSeed;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.runtime.context.scope.refresh.RefreshEvent;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@MicronautTest
public class RefreshableTest {
    @Inject
    RefreshableSeed refreshableSeed;

    @Inject
    ApplicationEventPublisher<RefreshEvent> eventPublisher;

    @Test
    void refreshableBeanGetsRefreshedWithRefreshEvent(){
        final var firstSeed = refreshableSeed.latestSeed();
        assertEquals(firstSeed, refreshableSeed.latestSeed());
        System.out.println("before refreshing: ");
        System.out.println("firstSeed: " + firstSeed);
        System.out.println("latestSeed: " + refreshableSeed.latestSeed());
        eventPublisher.publishEvent(new RefreshEvent());
        System.out.println("after refreshing: ");
        System.out.println("firstSeed: " + firstSeed);
        System.out.println("latestSeed: " + refreshableSeed.latestSeed());
        assertNotEquals(firstSeed, refreshableSeed.latestSeed());
    }
}
