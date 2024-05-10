package com.example.donacion.controller;


import com.example.donacion.model.ProductoStock;
import com.example.donacion.model.Usuario;
import com.example.donacion.service.CategoriaService;
import com.example.donacion.service.ProductoStockService;
import com.example.donacion.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping(value = "/donacion/donante")
public class DonanteController {
	
	/**
	 * 
	 * @param id identificador del Vendedor
	 * @param model  contiene los atributos de las vistas.
	 * @return la pagina con el listado de productoStock asociado al id del vendedor.
	 */
	@GetMapping(value ="/misproductos/{id}")
	public String listarProductos( Model model, @PathVariable("id") Integer id) {
		
		Usuario usuario=vendedorServices.obtenerPorId(id.longValue());
		//List<ProductoStock> productoStockList = productoStockServices.findByDonante(Math.toIntExact(usuario.getId()));

		
		model.addAttribute("productoStocks", usuario.getProductoStocks());
		
		
		return listaProductos;
	}
	
	/**
	 * busca un productoStock por id y luego lo agrega al modelo.
	 * 
	 * @param id identificador del productoStock  que se va a actualizar.
	 * @param model contiene los atributos de las vistas.
	 * @return la pagina de actualizacion de producto cargada con los datos del producto que será actualizado.
	 */
	@GetMapping(value ="/producto/actualizar/{id}")
	public String vistaactualizarProducto(@PathVariable(name = "id")Long id,Model model) {
		
		ProductoStock productoActualizar=productoStockServices.getById(id);
		model.addAttribute("productoActualizar", productoActualizar);
		return vistaactualizar;
	}
	
	
	/**
	 * elimina un productoStock. Busca un ProductoStock por id y luego lo elimina. 
	 * 
	 * @param id identificador del productoStock  que se va a eliminar.
	 * @param redirectAttributes tributos de redireccion de paginas. 
	 * @return redirecciona a la pagina actual.
	 */
	@GetMapping(value ="/producto/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id")Long id,RedirectAttributes redirectAttributes) {
		
		productoStockServices.eliminarProducto(id);
		redirectAttributes.addFlashAttribute("msjEliminado",msjEliminado);
		
		return eliminar;
	}
	
	@GetMapping(value ="/producto/nuevo")
	public String vistaagregarProducto(ProductoStock producto) {
		
		return vistaagregar;
	}
	
	
	
	/**
	 * 
	 * @param producto  recibe el producto que sera guatdado en la base de datos.
	 * @param bindingResult contiene algunas caracteristicas de la validacion del productoActualizar y permite saber el estado de la valdacion.
	 * @param redirectAttributes  contiene atributos de redireccion de paginas. 
	 * @return
	 */
	@PostMapping(value ="/producto/agregar")
	public String agregarProducto(@Valid ProductoStock producto,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return vistaagregar;
		}
		else {
			productoStockServices.guardarProducto(producto);
			redirectAttributes.addFlashAttribute("msj",msjAgregado);
			return redirectListado;
		}
		
	}
	
	/**
	 * 
	 * @param productoActualizar recibe el producto que contiene los datos que se van a actualizar de un producto en la base de datos.
	 * @param bindingResult contiene algunas caracteristicas de la validacion del productoActualizar y permite saber el estado de la valdacion.
	 * @param redirectAttributes contiene atributos de redireccion de paginas. 
	 * @return en caso de que la validacion tenga errores devolverá la vista actual mostrando los errores,
	 * de lo contrario redireccionara a la vista al listado de productosStock.
	 */
	@PostMapping(value ="/producto/actualizado")
	public String actualizarProducto(@Valid @ModelAttribute("productoActualizar") ProductoStock productoActualizar,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		
		
		if(bindingResult.hasErrors()) {
			return vistaactualizar;
		}
		else {
			
			
			productoStockServices.actualizarProducto(productoActualizar);
			redirectAttributes.addFlashAttribute("msj",msjActualizado);
			return redirectListado;
		}
		
	}


	@GetMapping( value = "/producto/{id}/informacion")
	public String informaciondelProductoCarrito(@PathVariable("id")Long id,Model model) {
		//Integer idr= 10;
		ProductoStock productoStock=productoStockServices.getById(id);
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
		model.addAttribute("productos", productoStockServices.getProductos());
	}
	
	
	
	
	private static final String listaProductos="vistasvendedores/misproductos";
	private static final String vistaactualizar="vistasvendedores/actualizarproducto";
	private static final String vistaagregar="vistasvendedores/agregarproducto";
	private static final String eliminar="redirect:/donacion/donante/misproductos";
	private static final String redirectListado="redirect:/donacion/donante/misproductos";
	private static final String msjAgregado="Se ha agregado un Nuevo producto al listado";
	private static final String msjActualizado="Se ha actualizado un producto del listado ";
	private static final String msjEliminado="Se ha eliminado un producto de la tienda ";
	
	
	@Autowired
	private CategoriaService categoriaServices;

	@Autowired
	private ProductoStockService productoStockServices;
	
	@Autowired
	private VendedorService vendedorServices;
}
