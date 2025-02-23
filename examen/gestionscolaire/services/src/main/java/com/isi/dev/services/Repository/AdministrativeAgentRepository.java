package com.isi.dev.services.Repository;

import com.isi.dev.services.Entity.AdministrativeAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativeAgentRepository extends JpaRepository<AdministrativeAgent, Long> {}

