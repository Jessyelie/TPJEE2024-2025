package com.groupeisi.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ref", nullable = true)
    private String ref;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "stock", nullable = true)
    private Double stock;

    @Column(name = "id_user", nullable = true)
    private Long idUser;

    // Relation avec Sales (une liste de ventes pour un produit)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sales> sales;

    // Relation avec Purchases (une liste d'achats pour un produit)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchases> purchases;
}
