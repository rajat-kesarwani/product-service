package com.example.productservice.services;

import com.example.productservice.Exceptions.ProductNotExitsException;
import com.example.productservice.models.Product;

import java.util.List;


public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExitsException;

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    Product addNewProduct(Product product);

    boolean deleteProduct(Long id);
}
