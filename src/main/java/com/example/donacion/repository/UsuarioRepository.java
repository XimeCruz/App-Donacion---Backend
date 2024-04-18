package com.example.donacion.repository;


import com.example.donacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByCorreoElectronico(String email);

    public boolean existsByCorreoElectronico(String email);


}
