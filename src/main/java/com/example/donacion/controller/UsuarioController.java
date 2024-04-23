package com.example.donacion.controller;

import com.example.donacion.model.Usuario;
import com.example.donacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String mostrarUsuario(Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(1L); // Suponiendo que el usuario con ID 1 existe
        model.addAttribute("usuario", usuario);
        return "usuario";
    }
}
