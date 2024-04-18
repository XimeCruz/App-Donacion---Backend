package com.example.donacion.controller;

import com.example.donacion.model.ProductoStock;
import com.example.donacion.service.CategoriaService;
import com.example.donacion.service.ProductoStockService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/donacion")
public class HomeController {

	
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
	@GetMapping(value ="/principal")
	public String principal(Model model,Pageable page) {

		Page<ProductoStock> productos =productoStockServices.getProductos(page);
		model.addAttribute("productos",productos);
		model.addAttribute("ispageable", true);

		return "principal/principal";
	}

	@GetMapping(value ="/donacion")
	public String donacion(Model model,Pageable page) {

		Page<ProductoStock> productos =productoStockServices.getProductos(page);
		model.addAttribute("productos",productos);
		model.addAttribute("ispageable", true);

		return "principal/donaciones";
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
}
