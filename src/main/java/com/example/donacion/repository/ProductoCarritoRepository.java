package com.example.donacion.repository;


import com.example.donacion.model.ProductoCarrito;
import com.example.donacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoCarritoRepository extends JpaRepository<ProductoCarrito,Long> {

    List<ProductoCarrito> findByBeneficiario(Usuario beneficiario);

}
