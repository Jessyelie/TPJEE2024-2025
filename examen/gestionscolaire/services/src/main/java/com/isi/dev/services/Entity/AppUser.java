package com.isi.dev.services.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_pro", unique = true, nullable = false)
    private String emailPro; // Utilisé comme identifiant (username)

    @Column(name = "token", nullable = false)
    private String token; // Utilisé comme mot de passe (password)
}
