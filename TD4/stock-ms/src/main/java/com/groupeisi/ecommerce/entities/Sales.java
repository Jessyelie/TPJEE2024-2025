package com.groupeisi.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_p", nullable = true)
    private Date dateP;

    @Column(name = "quantity", nullable = true)
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @Column(name = "user_id", nullable = true)
    private Long idUser;
}
