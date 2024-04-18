package com.example.donacion.controller;

import com.example.donacion.model.Usuario;
import com.example.donacion.service.ClienteService;
import com.example.donacion.service.RolService;
import com.example.donacion.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/donacion")
public class RegistroController {

	
	@PostMapping(value = "/registro")
	public String registrarCuenta(@Valid Usuario usuario,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model) {
		
		/**
		 * agregar mensaje al modelo en caso de que el correo electronico ya este en la base de datos
		 */
		if(clienteServices.existsByEmail(usuario.getCorreoElectronico())|
				vendedorServices.existsByEmail(usuario.getCorreoElectronico())) {
			model.addAttribute("msjEmailExistente", msjEmailExistente);
			
		}
		
		/**
		 * verificar si todos los campos estan rellenados correctamente  
		 * verificar si el correo electronico no se encuentra registrado para que no ocurra una exepcion
		 * 
		 */
		if(bindingResult.hasErrors()| !usuario.validPasword()|!usuario.esMayordeEdad()|
				clienteServices.existsByEmail(usuario.getCorreoElectronico())| 
				vendedorServices.existsByEmail(usuario.getCorreoElectronico())) {
			
			return registro;
		}
		
		
		else {
			String passwordCodificada=passwordEncoder.encode(usuario.getPassword());
			usuario.setPassword(passwordCodificada);
			
			if(usuario.getRol().getId()==1) {
				clienteServices.crearCuenta(usuario);
			}
			else if(usuario.getRol().getId()==2) {
				vendedorServices.crearCuenta(usuario);
			}
			redirectAttributes.addFlashAttribute("msjcuentacreada",creada );
			redirectAttributes.addFlashAttribute("usuario",usuario); 
			return vistainicio;
		}
		
		
	}
	
	
	/**
	 * Contiene algunos atributos necesarios para las vistas.
	 * 
	 * @param model contiene los atributos que viajaran del controlador a las vistas.
	 */
	@ModelAttribute
	public void atributes(Model model) {
		model.addAttribute("roles",rolServices.getRoles());
	}
	
	
	
	
	private final String registro="inicio-registro/registro";
	private final String creada="¡ Tu cuenta se creó con exito !";
	private final String vistainicio="redirect:/donacion/inicio";
	private final String msjEmailExistente="El correo electronico ya está registrado";
	@Autowired
	private RolService rolServices;

	@Autowired
	private ClienteService clienteServices;
	
	@Autowired
	private VendedorService vendedorServices;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
}
