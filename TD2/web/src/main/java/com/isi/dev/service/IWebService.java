package com.isi.dev.service;

import com.isi.dev.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWebService extends JpaRepository<AppUser,Long> {
}
