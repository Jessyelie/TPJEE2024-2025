package com.isi.dev.services;

import com.isi.dev.services.Interfaces.ICommandesServices;

public class CommandesServices implements ICommandesServices {
    @Override
    public String getCommandes() {
        return "les Commandes sont visible";
    }
}
