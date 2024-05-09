package com.example.donacion.repository;

import com.example.donacion.model.Categoria;
import com.example.donacion.model.ProductoStock;
import com.example.donacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ProductoStockRepository extends JpaRepository<ProductoStock,Long> {

    List<ProductoStock> findByCategoria(Categoria categoria);

    public List<ProductoStock> findByFechaDeVencimientoBetween(Date fechaIni, Date fechaFin);

    List<ProductoStock> findByDonante(Usuario usuario);
 }
