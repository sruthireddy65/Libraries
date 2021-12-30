package com.self.libraries.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

public class FluxTest {

    @Test
    public void testFlux(){
        Flux.just("A","B","C")
                .log()
                .subscribe();
    }

    @Test
    public void testFluxIterable(){
        Flux.fromIterable(Arrays.asList("A","B","C"))
                .log()
                .subscribe();
    }

    @Test
    public void testFluxInfinite() throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .log()
                .subscribe();
        Thread.sleep(5000);
    }

    @Test
    public void testFluxRange() {
       Flux.range(10,5)
               .log()
               .take(3)
               .subscribe(s -> System.out.println(s));
    }

    @Test
    public void testFluxBackPressure(){
        Flux.range(10,10)
                .log()
                .limitRate(3)
                .subscribe();
    }

    @Test
    public void testFluxSubscribe(){
        Flux.range(10,10)
                .log()
                .subscribe(s -> System.out.println(s),null,null, s -> s.request(3));
    }
}
