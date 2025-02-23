package com.isi.dev.web.Controller;


import com.isi.dev.services.Entity.AppUser;
import com.isi.dev.services.Service.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final EcoleService ecoleService;


    @GetMapping
    public List<AppUser> obtenirTousLesUsers() {
        return ecoleService.trouverTousLesUsers();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> obtenirUserParId(@PathVariable Long id) {
        return ecoleService.trouverUserParId(id);
    }

    @PostMapping
    public AppUser ajouterUser(@RequestBody AppUser user) {
        user.setToken(UUID.randomUUID().toString().split("-")[1]);
        return ecoleService.ajouterUser(user);
    }

    @PutMapping("/{id}")
    public AppUser modifierUser(@PathVariable Long id, @RequestBody AppUser user) {
        user.setId(id);
        return ecoleService.modifierUser(user);
    }
    @DeleteMapping("/{id}")
    public void supprimerUser(@PathVariable Long id) {
        ecoleService.supprimerUser(id);
    }


//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
//        System.out.println(email+" "+password);
//        Optional<AppUser> user = ecoleService.trouverParLogin(email);
//        System.out.println(user);
//        if (user.isPresent() && user.get().getToken().equals(password)) {
//            String newToken = UUID.randomUUID().toString().split("-")[1];
//            System.out.println(newToken);
//            user.get().setToken(newToken);
//            ecoleService.modifierUser(user.get());
//            return ResponseEntity.ok("Login réussi !");
//        } else {
//            return ResponseEntity.status(401).body("Identifiants incorrects");
//        }
//    }

}