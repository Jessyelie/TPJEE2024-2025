package com.groupeisi.ecommerce.repository;

import com.groupeisi.ecommerce.dto.SalesDTO;
import com.groupeisi.ecommerce.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
