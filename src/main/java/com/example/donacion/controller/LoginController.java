package com.example.donacion.controller;


import com.example.donacion.model.Usuario;
import com.example.donacion.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/donacion")
public class LoginController {

	@GetMapping(value = "/inicio")
	public String iniciarSesion(Usuario usuario) {

        return "inicio-registro/inicio";
	}

	@GetMapping(value = "/registro")
	public String registrar(Usuario usuario) {

        return "inicio-registro/registro";
	}

	@ModelAttribute
	public void atributes(Model model) {
		model.addAttribute("roles",rolServices.getRoles());

	}



	@Autowired
	private RolService rolServices;

}
