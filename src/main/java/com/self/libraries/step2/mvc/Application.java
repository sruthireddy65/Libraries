package com.self.libraries.step2.mvc;

import com.self.libraries.webflux.model.Product;
import com.self.libraries.webflux.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;


@EntityScan({"com.self.libraries.step2.mvc" })
@EnableJpaRepositories({"com.self.libraries.step2.mvc"})
@EnableReactiveMongoRepositories(basePackages = {"com.self.libraries.webflux.repository"})
@SpringBootApplication(scanBasePackages = {"com.self.libraries"})
//@ComponentScan("com.self")
public class Application implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<Product> productFlux = Flux.just(new Product(null,"p1",100d),
                new Product(null,"p2",200d))
                .flatMap(product -> productRepository.save(product));
        productFlux.thenMany(productRepository.findAll())
                .subscribe(System.out::println);
    }
}