package com.example.donacion.repository;

import com.example.donacion.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
}
