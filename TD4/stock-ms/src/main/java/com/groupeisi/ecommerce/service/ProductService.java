package com.groupeisi.ecommerce.service;

import com.groupeisi.ecommerce.dto.ProductDTO;
import com.groupeisi.ecommerce.entities.Product;
import com.groupeisi.ecommerce.entities.Sales;
import com.groupeisi.ecommerce.mapper.ProductMapper;
import com.groupeisi.ecommerce.repository.ProductRepository;
import com.groupeisi.ecommerce.repository.SalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductDTO addProduct(ProductDTO productDTO) {
        logger.info("Début de l'ajout d'un produit : {}", productDTO);

        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);

        logger.info("Produit ajouté avec succès : {}", savedProduct);
        return productMapper.toDTO(savedProduct);
    }

    public List<ProductDTO> getAllProducts() {
        logger.info("Récupération de tous les produits...");

        List<Product> products = productRepository.findAll();
        logger.info("Nombre de produits récupérés : {}", products.stream().toList());

        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
    public ProductDTO findProductInDTOFormat(Long id) {
        logger.info("Récupération de tous les produits...");
        Product product = productRepository.findById(id).orElse(new Product());
        logger.info("Le produits récupérés est ", product);
        return productMapper.toDTO(product);
    }
    public Product findProductInEntityFormat(Long id) {
        logger.info("Récupération de tous les produits...",id);
        Product product = productRepository.findById(id).orElse(new Product());
        logger.info("Le produits récupérés est ", product);
        return product;
    }

    public Product recalculateProductInEntityFormat(Long productId, Long saleId) {
        logger.info("Récupération du produit avec l'ID {} et de la vente avec l'ID {}", productId, saleId);

        // Récupération du produit
        Product product = productRepository.findById(productId).orElse(null);

        // Récupération de la vente
        Sales sales = salesRepository.findById(saleId).orElse(null);

        if (product == null) {
            logger.warn("Le produit avec l'ID {} n'a pas été trouvé.", productId);
            return null;
        }

        if (sales == null) {
            logger.warn("La vente avec l'ID {} n'a pas été trouvée.", saleId);
            return product;
        }

        // Vérification de la relation entre la vente et le produit
        if (!sales.getProduct().getId().equals(productId)) {
            logger.warn("La vente {} n'est pas associée au produit {}.", saleId, productId);
            return product;
        }

        // Mise à jour de la quantité du produit
        double updatedQuantity = product.getStock() - sales.getQuantity();

        // Empêcher une quantité négative
        updatedQuantity = Math.max(updatedQuantity, 0);

        product.setStock(updatedQuantity);

        // Sauvegarde du produit mis à jour
        productRepository.save(product);

        logger.info("Produit mis à jour avec succès : {}", product);
        return product;
    }


}
