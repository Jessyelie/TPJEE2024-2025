package com.groupeisi.ecommerce.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String ref;
    private String name;
    private Double stock;
    private Long idUser;
}
