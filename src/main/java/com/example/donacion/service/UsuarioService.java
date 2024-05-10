package com.example.donacion.service;


import com.example.donacion.model.Usuario;
import com.example.donacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario obtnerUsuarioPorNombreUsuario (String nombre){
        return usuarioRepository.findUsuarioByNombreUsuario(nombre);
    }
}
