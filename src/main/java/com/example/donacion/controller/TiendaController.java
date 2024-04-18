package com.example.donacion.controller;

import com.example.donacion.model.ProductoStock;
import com.example.donacion.service.CategoriaService;
import com.example.donacion.service.ProductoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/donacion")
public class TiendaController {

	/**
	 * 
	 * @param id el identificador de la categoria
	 * @param model contiene los atributos de las vistas.
	 * @return la vista principal
	 */
	@GetMapping(value = "/categoria/{id}")
	public String productosPorCatgeoria(@PathVariable("id") Long id,Model model) {
		
		List<ProductoStock> productos=productoStockServices.porCategoria(id);
		model.addAttribute("productos", productos);
		return vistaprincipal;
		
	}
	
	/**
	 * 
	 * @param minimo precio minimo.
	 * @param maximo precio maximo. 
	 * @param model contiene los atributos de las vistas.
	 * @return  la vistra principal con el resultado de la busqueda.
	 */
	@GetMapping(value = "/productos/buscar/precio")
	public String productosPorRangoDePrecio(@RequestParam(name = "desde",required =false) Double minimo,@RequestParam(name = "hasta",required =false)Double maximo,Model model) {
		
		List<ProductoStock> productos=null;
		
		if(minimo!=null&& maximo!=null) {
			productos=productoStockServices.porRangoDePrecios(minimo, maximo);
		}
		
		else if (minimo==null&&maximo!=null) {
			productos=productoStockServices.porPrecioMenorA(maximo);
		}
		else if (maximo==null&&minimo!=null) {
			productos=productoStockServices.porPrecioMayorA(minimo);
		}

		
		
		model.addAttribute("productos", productos);
		return vistaprincipal;
		
	}
	
	
	
	/**
	 * 
	 * @param orden parametro que indica el tipo de operacion a realizar con los productos de la tienda.
	 * @param model contiene los atributos de las vistas.
	 * @return la vistra principal con el resultado de la busqueda
	 */
	@GetMapping(value = "/productos")
	public String productosEnorden(@RequestParam(name = "orden")String orden,Model model) {
		
		List<ProductoStock> productos=null;
		
		if(orden.equalsIgnoreCase("fecha_ASC")) {
			productos=productoStockServices.porFechaDepublicacion();
			
		}
		else if(orden.equalsIgnoreCase("precio_ASC")) {
			productos=productoStockServices.deMenorAMayorPrecio();
			
		}
		else if(orden.equalsIgnoreCase("precio_DESC")) {
			productos=productoStockServices.deMayorAMenorPrecio();
		}
		else if(orden.equalsIgnoreCase("cantidad_disponible_DESC")) {
			productos=productoStockServices.porCantidadDisponible();
		}
		
		model.addAttribute("productos", productos);
		
		return vistaprincipal;
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
	
	
	@Autowired
	private ProductoStockService productoStockServices;
	
	@Autowired
	private CategoriaService categoriaServices;
	
	private final String vistaprincipal="principal/principal";

}
