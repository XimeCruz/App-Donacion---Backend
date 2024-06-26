package com.example.donacion.controller;

import com.example.donacion.model.*;
import com.example.donacion.model.response.DonacionResponse;
import com.example.donacion.repository.DonacionV2Repository;
import com.example.donacion.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/donacion")
public class HomeController {

	@Autowired
	NotificacionService notificacionService;

	@Autowired
	UsuarioService usuarioService;
    @Autowired
    private DonacionV2Repository donacionV2Repository;

	/**
	 * devuelve la ubicacion del archivo en el que se encuentra la pagina principal.
	 * 
	 * @return la pagina principal.
	 */
	@GetMapping(value = "/")
	public String getHome() {
		
		return home;
	}
	
	@GetMapping(value = "/logout")
	public String cerrarSession() {
		
		return logout;
	}
	
	
//	@GetMapping(value = "/auth")
//	private String autenticacionDeUsuario(Authentication auth,HttpSession httpSession) {
//		if (auth.isAuthenticated()) {
//			// La autenticación fue exitosa
//			// Realiza cualquier acción adicional que necesites
//			return "redirect:/donacion/principal"; // Redirige a la página principal
//		} else {
//			// La autenticación no fue exitosa
//			// Maneja el caso de autenticación fallida según sea necesario
//			return "redirect:/home"; // Redirige a una página de inicio de sesión
//		}
//	}
	
	
	/**
	 * redirige a la pagina principal de un usuario Cliente.
	 * 
	 * @param model contiene los atributos de las vistas.
	 * @return la pagina principal.
	 */
	@PostMapping(value ="/usuario")
	public String principal(@RequestParam String username, @RequestParam String password, Model model, Pageable page) {

		System.out.println("Usuario: " + username);
		System.out.println("Contraseña: " + password);

		Usuario usuario = usuarioService.obtnerUsuarioPorNombreUsuario(username);

		if(usuario == null){
			model.addAttribute("error", "Usuario no encontrado");
			return "inicio-registro/inicio";
		}

		Integer id = usuario.getId().intValue();

		switch (usuario.getRol().getNombre()) {
			case "Donante":
				return "redirect:/donacion/donante/misproductos/"+id;

			case "Beneficiario":
				return "redirect:/donacion/albergue/principal/"+id;

			case "Voluntario":
				return "redirect:/donacion/voluntario/principal/"+id;
		
			default:
				return "redirect:/donacion/principal";
		}

		
	}

	@GetMapping(value ="/principal")
	public String principal(Model model, Pageable page) {

		Page<ProductoStock> productos = productoStockServices.getProductos(page);
		model.addAttribute("productos", productos);
		model.addAttribute("ispageable", true);

		Notificacion notification = obtenerNotificacion();
		if (notification != null) {
			System.out.println(notification);
			notificacionService.guardarNotificacion(notification);
			model.addAttribute("notification", notification);
		} else {
			model.addAttribute("notification", null);
		}

		return "principal/principal";
	}

	private Notificacion obtenerNotificacion() {
		Notificacion notificacion = new Notificacion();

		List<ProductoStock> productoStocks = notificacionService.obtenerProductosProximosAVencer();

		if (!(productoStocks == null)) {
			ProductoStock ultimoProducto = productoStocks.get(productoStocks.size() - 1);
			System.out.println("El último producto es: " + ultimoProducto);
			notificacion.setMensaje("El producto "+ultimoProducto.getNombre()+" esta proximo a venderse");
			notificacion.setProducto(ultimoProducto);
			return notificacion;
		} else {
			System.out.println("La lista de productos está vacía.");
		}

		return null;
	}

//	@GetMapping(value ="/donacion")
//	public String donacion(Model model,Pageable page) {
//
//		List<Donacion> donaciones = donacionService.getAllDonacions();
//		List<DonacionResponse> donacionResponses = new ArrayList<>();
//        for (Donacion donacion : donaciones) {
//            DonacionResponse donacionResponse = new DonacionResponse();
//            donacionResponse.setFechaAdquisicion(String.valueOf(donacion.getFecha_adquisicion()));
//            donacionResponse.setCantidad(donacion.getCantidad());
//            donacionResponse.setNombreProducto(donacion.getProducto().getNombre());
//            donacionResponse.setNombreOrganizacion(donacion.getOrganizacion().getNombre_org());
//            donacionResponse.setNombreDonante(donacion.getDonante().getNombre());
//            donacionResponse.setNombreVoluntarioRecojo(donacion.getVoluntarioRecojo().getNombre());
//            donacionResponses.add(donacionResponse);
//        }
//        //return donacionResponses;
//
//
//
//		//System.out.println(donaciones);
//		model.addAttribute("donaciones", donacionResponses);
//		//System.out.println(model);
//
//		return "principal/donaciones";
//	}


	@GetMapping(value ="/donacion")
	public String donacion(Model model,Pageable page) {

		List<DonacionV2> donaciones = donacionV2Repository.findAll();
        model.addAttribute("donaciones", donaciones);
		return "principal/lista-donacion";
	}


	boolean aceptarDonacionbOL(Long id) {
        Optional<DonacionV2> optionalDonacion = donacionV2Repository.findById(id);
        if (optionalDonacion.isPresent()) {
            DonacionV2 donacion = optionalDonacion.get();
            donacion.setAceptado(true);
            donacionV2Repository.save(donacion);
            return true;
        }
        return false;
    }

	@PostMapping("/aceptarDonacion/{id}")
    @ResponseBody
    public ResponseEntity<?> aceptarDonacion(@PathVariable Long id) {
        boolean success = aceptarDonacionbOL(id);
        return ResponseEntity.ok(Collections.singletonMap("success", success));
    }
	
	/**
	 * busca un productoCarrito por id y devuelve una pagina cargada con la informacion del producto.
	 * 
	 * @param id identificador del productoCarrito que se va a ver la informacion.
	 * @param model contiene los atributos de las vistas.
	 * @return la pagina de detalles de un producto.
	 */
	@GetMapping( value = "/producto/{id}/informacion")
	public String informaciondelProductoCarrito(@PathVariable("id")Long id,Model model) {
		Integer idr= 10;
		ProductoStock productoStock=productoStockServices.getById(idr.longValue());
		model.addAttribute("productoInfo",productoStock);
		model.addAttribute("delCarrito", true);

		return "vistascompradores/informacionproducto";
	}
	
	
	
	/**
	 * Contiene algunos atributos necesarios para las vistas.
	 * 
	 * @param model contiene los atributos de las vistas.
	 */
	@ModelAttribute
	public void atributes(Model model) {
		
		model.addAttribute("categorias", categoriaServices.getCategoriasAsc());
		
	}
	

	
	private final String home="principal/home";
	private final String logout="principal/logout";
	private final String vistaprincipal="principal/principal";
	private final String vistaInformacionProducto="";
	
	@Autowired
	private ProductoStockService productoStockServices;

	@Autowired
	private CategoriaService categoriaServices;

	@Autowired
	private DonacionService donacionService;

}
