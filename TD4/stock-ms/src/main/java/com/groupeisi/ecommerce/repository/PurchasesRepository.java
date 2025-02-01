package com.groupeisi.ecommerce.repository;

import com.groupeisi.ecommerce.dto.ProductDTO;
import com.groupeisi.ecommerce.entities.Product;
import com.groupeisi.ecommerce.entities.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesRepository extends JpaRepository<Purchases, Long> {
}
