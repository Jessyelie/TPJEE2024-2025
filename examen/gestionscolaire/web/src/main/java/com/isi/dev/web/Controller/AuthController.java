package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.AppUser;
import com.isi.dev.services.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser user) {
        return ResponseEntity.ok(authService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        System.out.println("Données reçues : " + credentials); // Vérification

//        if (!credentials.containsKey("emailPro") || !credentials.containsKey("token")) {
//            return ResponseEntity.badRequest().body(Map.of("error", "Champs manquants"));
//        }


        String emailPro = credentials.get("emailPro");
        String token = credentials.get("token");
        System.out.println("EmailPro:--------> " + emailPro+" --- "+"token:--------> "+token);
        try {
            AppUser u = authService.authenticate(emailPro, token);
            System.out.println("userselectionné: " + u); // Vérification
            return ResponseEntity.ok(u);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", "Identifiants incorrects"));
        }
    }


}
