package com.isi.dev.services.Service;

import com.isi.dev.services.Entity.AppUser;
import com.isi.dev.services.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;


    public AppUser authenticate(String emailPro, String token) {
        Optional<AppUser> user = userRepository.findByEmailPro(emailPro);
         if(user.isPresent()) {
             return user.get();
        }else {
             return null;
         }
    }

    public AppUser registerUser(AppUser user) {
        return userRepository.save(user); // Stockage du token en clair
    }
}
