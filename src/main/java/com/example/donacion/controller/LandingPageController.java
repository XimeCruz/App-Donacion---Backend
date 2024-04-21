package com.example.donacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/donacion")
public class LandingPageController {

    @GetMapping("/home")
    public String details(Model model) {
        model.addAttribute("title", "Hola Mundo con Spring Boot");
        model.addAttribute("nombre", "Ximena");
        model.addAttribute("apellido", "Cruz");

        return "home";
    }
}

