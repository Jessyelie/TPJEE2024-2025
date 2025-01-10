package com.isi.dev.batch;

import com.isi.dev.services.Commande;
import com.isi.dev.services.Interfaces.ICommande;


public class Main {
    public ICommande commande=new Commande();
    public static void main(String[] args) {

        System.out.println(commande);
    }
}