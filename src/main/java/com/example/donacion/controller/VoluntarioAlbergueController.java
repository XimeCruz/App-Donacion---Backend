package com.example.donacion.controller;
import com.example.donacion.service.AlbergueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class VoluntarioAlbergueController {

    @Autowired
    private AlbergueService albergueService;

    // Método para mostrar la lista de albergues que necesitan alimentos
//    @GetMapping("/albergues")
//    public String listarAlbergues(Model model) {
//        List<Albergue> albergues = albergueService.listarAlberguesNecesitados();
//        model.addAttribute("albergues", albergues);
//        return "albergues-voluntarios";
//    }
//
//    // Método para manejar la acción de coordinar entrega de alimentos
//    @PostMapping("/coordinarEntrega")
//    public String coordinarEntrega(@RequestParam("albergueId") Long albergueId, @RequestParam("voluntarioId") Long voluntarioId, Model model) {
//        boolean resultado = albergueService.coordinarEntrega(albergueId, voluntarioId);
//        if (resultado) {
//            model.addAttribute("mensaje", "La entrega ha sido coordinada exitosamente.");
//        } else {
//            model.addAttribute("mensaje", "Error al coordinar la entrega.");
//        }
//        return "resultado-coordinacion"; // Redirige a una página de resultado con el mensaje correspondiente
//    }
}
