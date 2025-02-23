package com.isi.dev.services.Repository;


import com.isi.dev.services.Entity.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionsRepository extends JpaRepository<Sessions, Long> {}
