package com.groupeisi.ecommerce.controller;

import com.groupeisi.ecommerce.dto.SalesDTO;
import com.groupeisi.ecommerce.service.ProductService;
import com.groupeisi.ecommerce.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;
    @Autowired
    private ProductService productService;

    @PostMapping
    public SalesDTO addSales(@RequestBody SalesDTO salesDTO) {
        System.out.println("-------------------------------------------"+salesDTO.toString());
        productService.recalculateProductInEntityFormat(salesDTO.getProductId(), salesDTO.getId());
        return salesService.addSales(salesDTO);
    }

    @GetMapping
    public List<SalesDTO> getAllSales() {
        return salesService.getAllSales();
    }
}
