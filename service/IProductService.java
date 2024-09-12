package com.productsservice.products.service;

import com.productsservice.products.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    Product getSingleProduct(Long Id);

    List<Product> getAllProducts();
}
