package com.self.libraries.webflux;

import com.self.libraries.webflux.model.Product;
import com.self.libraries.webflux.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController{

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Flux<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Product>> getProductById(@PathVariable String id){
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok(product))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> postProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable String id, @RequestBody Product product){
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    return productRepository.save(existingProduct);
                })
                .map(product1 -> ResponseEntity.ok(product1))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable String id){
        return productRepository.findById(id)
                .flatMap(product -> {
                    return productRepository.delete(product)
                            .then(Mono.just(ResponseEntity.ok().<Void>build()));
                }).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<Void> deleteAllProducts(){
        return productRepository.deleteAll();
    }
}