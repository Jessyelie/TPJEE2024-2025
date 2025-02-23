package com.isi.dev.services.Repository;


import com.isi.dev.services.Entity.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorsRepository extends JpaRepository<Sectors, Long> {}
