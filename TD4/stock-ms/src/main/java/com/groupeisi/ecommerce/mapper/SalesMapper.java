package com.groupeisi.ecommerce.mapper;

import com.groupeisi.ecommerce.dto.SalesDTO;
import com.groupeisi.ecommerce.entities.Sales;
import com.groupeisi.ecommerce.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class SalesMapper {

    public SalesDTO toDTO(Sales sales) {
        if (sales == null) {
            return null;
        }
        return new SalesDTO(
                sales.getId(),
                sales.getDateP(),
                sales.getQuantity(),
                sales.getProduct().getId(), // Obtenir l'ID du produit
                sales.getIdUser()
        );
    }

    public Sales toEntity(SalesDTO salesDTO) {
        if (salesDTO == null) {
            return null;
        }
        Sales sales = new Sales();
        sales.setId(salesDTO.getId());
        sales.setDateP(salesDTO.getDateP());
        sales.setQuantity(salesDTO.getQuantity());
        sales.setProduct(null);
        sales.setIdUser(salesDTO.getIdUser());
        return sales;
    }
}
