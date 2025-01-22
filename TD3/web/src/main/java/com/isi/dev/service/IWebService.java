package com.isi.dev.service;


import com.isi.dev.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWebService extends JpaRepository<Product,String> {
}
