package com.example.donacion.repository;

import com.example.donacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public List<Producto> findByFechaVencBefore (Date fecha);



}
