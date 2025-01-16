package com.isi.dev.services.service.Interface;

import com.isi.dev.services.entity.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommandeService{  //extends JpaRepository<Commandes,Long>
    String getCommandes();
}
