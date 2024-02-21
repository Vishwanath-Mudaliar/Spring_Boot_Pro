package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductModel;


public interface ProductRepositary extends JpaRepository<ProductModel, Integer>
{

}
