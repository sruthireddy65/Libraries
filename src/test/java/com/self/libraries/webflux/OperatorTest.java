package com.self.libraries.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class OperatorTest {

    @Test
    public void testMap(){
        Flux<Integer> integerFlux = Flux.just(10,20,30);
        integerFlux.map(x -> 10*x)
                .subscribe(s -> System.out.println(s));
    }

    @Test
    public void testFlatMap() {
        Flux<Integer> integerFlux = Flux.range(1,5);
        integerFlux.flatMap(x -> Flux.range(x*10, 2))
                .subscribe(s -> System.out.println(s));
    }

    @Test
    public void testConcat() throws InterruptedException {
        Flux<Integer> flux1To5 = Flux.range(1,5)
                .delayElements(Duration.ofMillis(200));
        Flux<Integer> flux6To10 = Flux.range(6, 5)
                .delayElements(Duration.ofMillis(400));
        flux1To5.concatWith(flux6To10)
                .subscribe(s -> System.out.println(s));
//        Flux.concat(flux1To5, flux6To10)
//                .subscribe(s -> System.out.println(s));
        Thread.sleep(5000);
    }

    @Test
    public void testMerge() throws InterruptedException {
        Flux<Integer> flux1To5 = Flux.range(1, 5)
                .delayElements(Duration.ofMillis(200));
        Flux<Integer> flux6To10 = Flux.range(6, 5)
                .delayElements(Duration.ofMillis(400));
        flux1To5.mergeWith(flux6To10)
                .subscribe(s -> System.out.println(s));
//        Flux.merge(flux1To5, flux6To10)
//                .subscribe(s -> System.out.println(s));
        Thread.sleep(5000);
    }

    @Test
    public void testZip(){
        Flux<Integer> flux1To5 = Flux.range(1,5);
        Flux<Integer> flux6To10 = Flux.range(6,5);
        flux1To5.zipWith(flux6To10)
                .subscribe(s -> System.out.println(s));
    }

}
