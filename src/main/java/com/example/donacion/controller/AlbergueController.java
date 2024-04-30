package com.example.donacion.controller;

import com.example.donacion.model.Albergue;
import com.example.donacion.model.Donacion;
import com.example.donacion.model.Notificacion;
import com.example.donacion.model.ProductoCarrito;
import com.example.donacion.model.ProductoStock;
import com.example.donacion.model.Usuario;
import com.example.donacion.model.response.DonacionResponse;
import com.example.donacion.service.CategoriaService;
import com.example.donacion.service.ClienteService;
import com.example.donacion.service.DonacionService;
import com.example.donacion.service.NotificacionService;
import com.example.donacion.service.ProductoCarritoService;
import com.example.donacion.service.ProductoStockService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping(value = "/donacion/albergue")
public class AlbergueController {

    @Autowired
    NotificacionService notificacionService;

    @Autowired
    private ProductoStockService productoStockServices;

    @Autowired
    private CategoriaService categoriaServices;

    @Autowired
    private DonacionService donacionService;

    @Autowired
	private ClienteService clienteServices;

	@Autowired
	private ProductoCarritoService productoCarritoServices;

    @GetMapping(value = "/")
    public String getHome() {
        return "principal/home";
    }
    
    @GetMapping(value = "/logout")
    public String cerrarSession() {
        return "principal/logout";
    }
    
    /**
     * redirige a la pagina principal de un usuario Cliente.
     * 
     * @param model contiene los atributos de las vistas.
     * @param page información de paginación.
     * @return la pagina principal.
     */
    @GetMapping(value = "/principal")
    public String principal(Model model, Pageable page) {
        Page<ProductoStock> productos = productoStockServices.getProductos(page);
        model.addAttribute("productos", productos);
        model.addAttribute("isPageable", true);

        return "beneficiario/principal";
    }

    /**
     * redirige a la pagina de donaciones de un usuario Cliente.
     * 
     * @param model contiene los atributos de las vistas.
     * @param page información de paginación.
     * @return la pagina de donaciones.
     */
    @GetMapping(value = "/albergue-donaciones")
    public String donacion(Model model, Pageable page) {
        List<Donacion> donaciones = donacionService.getAllDonacions();
        List<DonacionResponse> donacionResponses = new ArrayList<>();
        for (Donacion donacion : donaciones) {
            DonacionResponse donacionResponse = new DonacionResponse();
            donacionResponse.setFechaAdquisicion(String.valueOf(donacion.getFecha_adquisicion()));
            donacionResponse.setCantidad(donacion.getCantidad());
            donacionResponse.setNombreProducto(donacion.getProducto().getNombre());
            donacionResponse.setNombreOrganizacion(donacion.getOrganizacion().getNombre_org());
            donacionResponse.setNombreDonante(donacion.getDonante().getNombre());
            donacionResponse.setNombreVoluntarioRecojo(donacion.getVoluntarioRecojo().getNombre());
            donacionResponses.add(donacionResponse);
        }
        model.addAttribute("donaciones", donacionResponses);
        return "beneficiario/donaciones"; //templates que terminan con html
    }

    @GetMapping(value = "/producto/{id}/informacion")
    public String informacionDelProductoCarrito(@PathVariable("id") Long id, Model model) {
        ProductoStock productoStock = productoStockServices.getById(id);
        model.addAttribute("productoInfo", productoStock);
        model.addAttribute("delCarrito", true);

        return "beneficiario/informacionproducto";
    }
    
    @ModelAttribute
    public void atributes(Model model) {
        model.addAttribute("categorias", categoriaServices.getCategoriasAsc());
    }
    
    private Notificacion obtenerNotificacion() {
        List<ProductoStock> productoStocks = notificacionService.obtenerProductosProximosAVencer();
        if (!productoStocks.isEmpty()) {
            ProductoStock ultimoProducto = productoStocks.get(productoStocks.size() - 1);
            Notificacion notificacion = new Notificacion();
            notificacion.setMensaje("El producto " + ultimoProducto.getNombre() + " está próximo a vencer");
            notificacion.setProducto(ultimoProducto);
            return notificacion;
        }
        return null;
    }

    @GetMapping("/albergue")
    public String getAlbergue(Model model) {
        Albergue albergue = new Albergue();
        albergue.setNombre("Albergue Esperanza");
        albergue.setDireccion("123 Calle Ficticia, Ciudad");
        albergue.setImagen("/images/albergue.jpg");
        albergue.setLatitud(40.730610); // Ejemplo de latitud
        albergue.setLongitud(-73.935242); // Ejemplo de longitud
        albergue.setCapacidad(100);

        model.addAttribute("albergue", albergue);
        model.addAttribute("apiKey", "r3NiLHgrItLbXSqA7eh4");

        return "beneficiario/albergue";
    }

    @GetMapping( value = "/producto/agregar/{id}")
	public String vistaAgregarAlCarrito(ProductoCarrito productoCarrito,@PathVariable("id")Long id, Model model) {
		
		ProductoStock productoStock=productoStockServices.getById(id);
		
		model.addAttribute("productoAgregar",productoStock);
		
		return "beneficiario/agregaralcarrito"; //template
	}

    @PostMapping(value = "/producto/agregar")
	public String AgregarProductoAlCarrito(ProductoCarrito productoCarrito,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		
		
		if(bindingResult.hasErrors()) {
			return "beneficiario/agregaralcarrito";
		}
		
		else {
			//if(clienteServices.buscarProductoStockEnCarritoCliente(productoCarrito.getProductoStock().getId(), auth)) {
			if(clienteServices.buscarProductoStockEnCarritoCliente(productoCarrito.getProductoStock().getId())) {
				redirectAttributes.addFlashAttribute("msjIntentoDeAgregado", "El producto ya se encuentra agregado a la canasta de donacion");
			}
			else {
				//productoCarritoServices.guardarProducto(productoCarrito, auth);
				Usuario cliente=clienteServices.GetbyEmail("Admin@gmail.com");
				productoCarrito.setBeneficiario(cliente);
				productoCarritoServices.guardarProducto(productoCarrito);
				redirectAttributes.addFlashAttribute("msj", "Se ha agregado un nuevo producto a la canasta de donacion");
			}
	
			return  "redirect:/donacion/beneficiario/elcarrito"; //CONTROLLER //GET POST PUT DELETE
		}
    }

    
    @GetMapping( value = "/elcarrito")
	public String alCarrito(Authentication authentication, Model model) {
		
		//Usuario cliente=clienteServices.GetbyEmail(authentication.getName());

		Usuario cliente=clienteServices.GetbyEmail("Admin@gmail.com");
		
		List<ProductoCarrito>productosCarrito=cliente.getProductoCarritos();
		model.addAttribute("ProductosCarrito", productosCarrito);
		
		return "beneficiario/carrito";
	}

}
