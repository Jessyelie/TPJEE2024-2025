package com.groupeisi.ecommerce.mapper;

import com.groupeisi.ecommerce.dto.ProductDTO;
import com.groupeisi.ecommerce.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setRef(dto.getRef());
        product.setName(dto.getName());
        product.setStock(dto.getStock());
        product.setIdUser(dto.getIdUser());
        return product;
    }

    public ProductDTO toDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setRef(entity.getRef());
        dto.setName(entity.getName());
        dto.setStock(entity.getStock());
        dto.setIdUser(entity.getIdUser());
        return dto;
    }
}
