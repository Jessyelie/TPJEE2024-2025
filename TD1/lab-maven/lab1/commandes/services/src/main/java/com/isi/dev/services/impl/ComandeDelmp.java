package com.isi.dev.services.impl;

import com.isi.dev.services.ICommande;
import org.springframework.stereotype.Service;

@Service
public class ComandeDelmp implements ICommande {
    @Override
    public String getCommande(){
        return "Commande de veicules";
    }
}
