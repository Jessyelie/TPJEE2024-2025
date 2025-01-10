package com.isi.dev.services;

import com.isi.dev.services.Interfaces.ICommande;

public class Commande implements ICommande {

    @Override
    public String getCommande() {
        return "Commande provenant de com.isi.dev.services";
    }

}
