package com.productsservice.products.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;

}
