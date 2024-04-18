package com.example.donacion.repository;


import com.example.donacion.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
