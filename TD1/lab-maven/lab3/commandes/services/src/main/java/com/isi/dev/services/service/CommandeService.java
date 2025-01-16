package com.isi.dev.services.service;

import com.isi.dev.services.entity.Commandes;
import com.isi.dev.services.service.Interface.ICommandeService;
import org.springframework.stereotype.Service;

@Service
public class CommandeService implements ICommandeService {

    @Override
    public String getCommandes() {
        return "voici la liste des commandes provenant de spring";
    }
}
