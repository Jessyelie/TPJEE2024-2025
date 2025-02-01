package com.groupeisi.ecommerce.service;

import com.groupeisi.ecommerce.dto.SalesDTO;
import com.groupeisi.ecommerce.entities.Sales;
import com.groupeisi.ecommerce.mapper.SalesMapper;
import com.groupeisi.ecommerce.repository.SalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {
    private static final Logger logger = LoggerFactory.getLogger(SalesService.class);

    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private SalesMapper salesMapper;

    public SalesDTO addSales(SalesDTO salesDTO) {
        logger.info("Début de l'ajout d'un produit : {}", salesDTO);

        Sales sales = salesMapper.toEntity(salesDTO);
        sales.setProduct(productService.findProductInEntityFormat(salesDTO.getProductId()));
        System.out.println(sales.toString());
        Sales savedSales = salesRepository.save(sales);

        logger.info("Produit ajouté avec succès : {}", savedSales);
        return salesMapper.toDTO(savedSales);
    }

    public List<SalesDTO> getAllSales() {
        logger.info("Récupération de tous les produits...");

        List<Sales> saless = salesRepository.findAll();
        logger.info("Nombre de produits récupérés : {}", saless.size());

        return saless.stream()
                .map(salesMapper::toDTO)
                .collect(Collectors.toList());
    }

}
