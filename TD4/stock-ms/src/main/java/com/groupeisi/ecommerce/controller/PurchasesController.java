package com.groupeisi.ecommerce.controller;

import com.groupeisi.ecommerce.dto.PurchasesDTO;
import com.groupeisi.ecommerce.service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {

    @Autowired
    private PurchasesService purchasesService;

    @PostMapping
    public PurchasesDTO addPurchases(@RequestBody PurchasesDTO purchasesDTO) {
        return purchasesService.addPurchases(purchasesDTO);
    }

    @GetMapping
    public List<PurchasesDTO> getAllPurchases() {
        return purchasesService.getAllPurchases();
    }
}
