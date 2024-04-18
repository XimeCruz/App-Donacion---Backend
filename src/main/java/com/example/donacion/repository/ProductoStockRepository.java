package com.example.donacion.repository;

import com.example.donacion.model.Categoria;
import com.example.donacion.model.ProductoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoStockRepository extends JpaRepository<ProductoStock,Long> {

    List<ProductoStock> findByCategoria(Categoria categoria);

    List<ProductoStock> findByPrecioBetween(Double min, Double max);
 }
