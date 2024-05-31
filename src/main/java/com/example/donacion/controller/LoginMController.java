package com.example.donacion.controller;

import com.example.donacion.model.Usuario;
import com.example.donacion.model.request.LoginMovil;
import com.example.donacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movil/login")
public class LoginMController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping(value ="/usuario")
	public ResponseEntity<?> principal(@RequestBody LoginMovil loginMovil, Pageable page) {

		Usuario usuario = usuarioService.obtnerUsuarioPorNombreUsuario(loginMovil.getNombreUser());

		if(usuario == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
		}
        else{
            Integer id = usuario.getId().intValue();
            return ResponseEntity.status(HttpStatus.OK).body(usuario);

//            switch (usuario.getRol().getNombre()) {
//                case "Donante":
//                    return "redirect:/donacion/donante/misproductos/"+id;
//
//                case "Beneficiario":
//                    return "redirect:/donacion/albergue/principal/"+id;
//
//                case "Voluntario":
//                    return "redirect:/donacion/voluntario/principal/"+id;
//
//                default:
//                    return "redirect:/donacion/principal";
//            }
        }


	}




}
