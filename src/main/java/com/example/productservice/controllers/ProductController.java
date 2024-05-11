package com.example.productservice.controllers;

import com.example.productservice.Exceptions.ProductNotExitsException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts()
    {
//        return productService.getAllProducts();

        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.FORBIDDEN
        );
        return response;
    }

    @GetMapping("/{id}")
    public Product getSingleProducts(@PathVariable("id") Long id) throws ProductNotExitsException {
        return productService.getSingleProduct(id);
    }

//    @PostMapping()
//    public Product addNewProduct(@RequestBody Product product) {
////        return productService.addNewProduct(product);
//        Product p = new Product();
//        p.setTitle("A new product");
//        return  p;
//    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return  new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id,product);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
