package com.example.donacion.controller;

import com.example.donacion.model.Notificacion;
import com.example.donacion.repository.NotificacionRepository;
import com.example.donacion.service.NotificacionService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping("/enviar-notificacion")
    public String enviarNotificacion() {
        notificacionService.enviarNotificacion("¡Hola! Esta es una notificación de ejemplo.");
        return "redirect:/";
    }

     @Autowired
    private NotificacionRepository notificacionRepository;

    @GetMapping("/notificaciones")
    public String mostrarNotificaciones(Model model) {
        List<Notificacion> notificaciones = notificacionRepository.findAll();
        model.addAttribute("notificaciones", notificaciones);
        return "notificaciones";
    }
}
