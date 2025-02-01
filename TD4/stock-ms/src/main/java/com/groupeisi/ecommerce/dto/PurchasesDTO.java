package com.groupeisi.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasesDTO {
    private Long id;
    private Date dateP;
    private Double quantity;
    private Long productId;
    private Long idUser;
}
