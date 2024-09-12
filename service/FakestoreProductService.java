package com.productsservice.products.service;

import com.productsservice.products.dtos.ProductRequestDto;
import com.productsservice.products.dtos.ProductResponseDto;
import com.productsservice.products.models.Category;
import com.productsservice.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreProductService implements IProductService{

    @Autowired
    RestTemplate restTemplate;
    public Product getSingleProduct(Long id){

        //RestTemplate restTemplate = new RestTemplate();

        ProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products" + id,ProductResponseDto.class);

        return getProductFromResponseDTO(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDto[] products=  restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDto[].class);

        List<Product> output = new ArrayList<>();
                for(ProductResponseDto productResponseDto: products){
                    output.add(getProductFromResponseDTO(productResponseDto));
                }

                return output;
    }

    private Product getProductFromResponseDTO(ProductResponseDto response){
        Product product = new Product();
        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setDescription(response.getDescription());
        product.setPrice(response.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(response.getCategory());
        product.setImage(response.getImage());

        return product;
    }
}
