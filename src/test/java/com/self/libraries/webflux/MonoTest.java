package com.self.libraries.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    public void testMonoJust(){
        Mono.just("ABC")
                .log()
                .subscribe();
    }

    @Test
    public void testMonodoMethods(){
        Mono.just("ABC")
                .log()
                .doOnSubscribe(s -> System.out.println("subscribed "+s))
                .doOnRequest(l -> System.out.println("requested "+l))
                .doOnNext(element -> System.out.println("Next :"+element))
                .doOnSuccess(success -> System.out.println("success "+success))
                .subscribe(s -> System.out.println("subscribe "+s));

    }

    @Test
    public void testMonoEmpty(){
        Mono.empty()
                .log()
                .subscribe();
    }

    @Test
    public void testMonoError(){
        Mono.error(new RuntimeException("exception occured"))
                .log()
                .subscribe();
    }

    @Test
    public void testMonoDoError(){
        Mono.error(new RuntimeException("exc"))
                .log()
                .doOnError(e -> System.out.println("error occured"))
                .subscribe(s -> System.out.println(s));
    }

    @Test
    public void testOnErrorResume(){
        Mono.error(new RuntimeException("ex"))
                .log()
                .onErrorResume(e -> {
                    System.out.println("error occured");
                    return Mono.just("B");
                })
                .subscribe(s -> System.out.println(s));
    }

    @Test
    public void testOnErrorReturn(){
        Mono.error(new RuntimeException())
                .log()
                .onErrorReturn("C")
                .subscribe(s -> System.out.println(s));
    }
}
