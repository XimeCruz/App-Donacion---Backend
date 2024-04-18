package com.example.donacion.service;


import com.example.donacion.model.Usuario;
import com.example.donacion.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendedorService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public void crearCuenta(Usuario vendedor) {

        usuarioRepository.save(vendedor);
    }

    public Boolean existsByEmail(String email) {

        return usuarioRepository.existsByCorreoElectronico(email);
    }


    public Usuario GetbyEmail(String email) {

        return usuarioRepository.findByCorreoElectronico(email);
    }

}
