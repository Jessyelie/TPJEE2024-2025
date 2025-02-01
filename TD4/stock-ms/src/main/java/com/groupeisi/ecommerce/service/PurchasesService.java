package com.groupeisi.ecommerce.service;

import com.groupeisi.ecommerce.dto.PurchasesDTO;
import com.groupeisi.ecommerce.entities.Purchases;
import com.groupeisi.ecommerce.mapper.PurchasesMapper;
import com.groupeisi.ecommerce.repository.PurchasesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchasesService {
    private static final Logger logger = LoggerFactory.getLogger(PurchasesService.class);

    @Autowired
    private PurchasesRepository purchasesRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private PurchasesMapper purchasesMapper;

    public PurchasesDTO addPurchases(PurchasesDTO purchasesDTO) {
        logger.info("Début de l'ajout d'un produit : {}", purchasesDTO);

        Purchases purchases = purchasesMapper.toEntity(purchasesDTO);
        purchases.setProduct(productService.findProductInEntityFormat(purchasesDTO.getProductId()));
        Purchases savedPurchases = purchasesRepository.save(purchases);

        logger.info("Produit ajouté avec succès : {}", savedPurchases);
        return purchasesMapper.toDTO(savedPurchases);
    }

    public List<PurchasesDTO> getAllPurchases() {
        logger.info("Récupération de tous les produits...");

        List<Purchases> purchasess = purchasesRepository.findAll();
        logger.info("Nombre de produits récupérés : {}", purchasess.size());

        return purchasess.stream()
                .map(purchasesMapper::toDTO)
                .collect(Collectors.toList());
    }

}
