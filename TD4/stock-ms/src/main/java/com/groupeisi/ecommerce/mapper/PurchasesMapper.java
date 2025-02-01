package com.groupeisi.ecommerce.mapper;

import com.groupeisi.ecommerce.dto.PurchasesDTO;
import com.groupeisi.ecommerce.entities.Purchases;
import com.groupeisi.ecommerce.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class PurchasesMapper {

    // Convertir Purchases en PurchasesDTO
    public PurchasesDTO toDTO(Purchases purchases) {
        if (purchases == null) {
            return null;
        }
        return new PurchasesDTO(
                purchases.getId(),
                purchases.getDateP(),
                purchases.getQuantity(),
                purchases.getProduct().getId(), // Obtenir l'ID du produit
                purchases.getIdUser()
        );
    }

    // Convertir PurchasesDTO en Purchases
    public Purchases toEntity(PurchasesDTO purchasesDTO) {
        if (purchasesDTO == null ) {
            return null;
        }
        Purchases purchases = new Purchases();
        purchases.setId(purchasesDTO.getId());
        purchases.setDateP(purchasesDTO.getDateP());
        purchases.setQuantity(purchasesDTO.getQuantity());
        purchases.setProduct(null);
        purchases.setIdUser(purchasesDTO.getIdUser());
        return purchases;
    }
}
