package com.groupeisi.gestionclasse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "administrative_agents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministrativeAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_pro")
    private String emailPro;

    @Column(name = "email_perso")
    private String emailPerso;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "archive")
    private boolean archive;
}
