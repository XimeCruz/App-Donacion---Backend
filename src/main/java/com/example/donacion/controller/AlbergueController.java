package com.example.donacion.controller;

import com.example.donacion.model.Albergue;
import com.example.donacion.model.Donacion;
import com.example.donacion.model.Notificacion;
import com.example.donacion.model.ProductoCarrito;
import com.example.donacion.model.ProductoStock;
import com.example.donacion.model.Usuario;
import com.example.donacion.model.response.DonacionResponse;
import com.example.donacion.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @Autowired
    private AlbergueService albergueService;

    @Autowired
    private UsuarioService usuarioService;

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
    @GetMapping(value = "/principal/{id}")
    public String principal(Model model, Pageable page, @PathVariable("id") Integer id) {

        

        Page<ProductoStock> productos = productoStockServices.getProductos(page);
        model.addAttribute("productos", productos);
        model.addAttribute("isPageable", true);
        model.addAttribute("idUsuario", id);

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

    @GetMapping(value = "/producto/{beneficiarioId}/informacion/{id}")
    public String informacionDelProductoCarrito(@PathVariable("id") Long id, Model model, @PathVariable("beneficiarioId")Long idBen) {
        ProductoStock productoStock = productoStockServices.getById(id);
        model.addAttribute("productoInfo", productoStock);
        model.addAttribute("delCarrito", true);
        model.addAttribute("beneficiarioId", idBen);

        return "beneficiario/informacionproducto";
    }

    @PostMapping("/redirectCarrito")
    public String handleCarritoRedirect(@RequestParam("beneficiarioId") Long beneficiarioId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("beneficiarioId", beneficiarioId);
        return "redirect:/donacion/albergue/elcarrito";
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



    @GetMapping( value = "{idUsuario}/producto/agregar/{id}")
	public String vistaAgregarAlCarrito(ProductoCarrito productoCarrito,@PathVariable("id")Long id, @PathVariable("idUsuario") Integer idUser, Model model) {
		
		ProductoStock productoStock=productoStockServices.getById(id);

		
		model.addAttribute("productoAgregar",productoStock);
        model.addAttribute("idUsuario", idUser);
		
		return "beneficiario/agregaralcarrito"; //template
	}

    @PostMapping(value = "/producto/agregar")
	public String AgregarProductoAlCarrito(ProductoCarrito productoCarrito,
                                           BindingResult bindingResult,
                                           RedirectAttributes redirectAttributes) {
        Usuario beneficiario = usuarioService.obtenerUsuarioPorId(productoCarrito.getBeneficiario().getId());

		if(bindingResult.hasErrors()) {
			return "beneficiario/agregaralcarrito";
		}
		
		else {
			//if(clienteServices.buscarProductoStockEnCarritoCliente(productoCarrito.getProductoStock().getId(), auth)) {
			if(clienteServices.buscarProductoStockEnCarritoCliente(productoCarrito.getProductoStock().getId(),beneficiario.getId())) {
				redirectAttributes.addFlashAttribute("msjIntentoDeAgregado", "El producto ya se encuentra agregado a la canasta de donacion");
			}
			else {
				//productoCarritoServices.guardarProducto(productoCarrito, auth);
				//Usuario cliente=clienteServices.GetbyEmail("Admin@gmail.com");

                //System.out.println(productoCarrito.getBeneficiario().getId());
				productoCarrito.setBeneficiario(beneficiario);
				productoCarritoServices.guardarProducto(productoCarrito);
				redirectAttributes.addFlashAttribute("msj", "Se ha agregado un nuevo producto a la canasta de donacion");


			}

            // Agregar el id del beneficiario a los redirectAttributes
                redirectAttributes.addFlashAttribute("beneficiarioId", beneficiario.getId());
	
			return  "redirect:/donacion/albergue/elcarrito"; //CONTROLLER //GET POST PUT DELETE
		}
    }

    
    @GetMapping( value = "/elcarrito")
	public String alCarrito(Model model,
                                @ModelAttribute("beneficiarioId") Integer beneficiarioId) {

        System.out.println(beneficiarioId);
		//Usuario cliente=clienteServices.GetbyEmail(authentication.getName());

		Usuario beneficiario = usuarioService.obtenerUsuarioPorId(beneficiarioId.longValue());
		
		List<ProductoCarrito>productosCarrito=beneficiario.getProductoCarritos();
		model.addAttribute("ProductosCarrito", productosCarrito);
        model.addAttribute("beneficiarioId", beneficiarioId);
		
		return "beneficiario/carrito";
	}


    @GetMapping( value = "/elcarrito/{beneficiarioId}/actualizar/{id}")
	public String vistaActualizar(@PathVariable("id")Long id, @PathVariable("beneficiarioId")Long idBen, Model model) {;

		ProductoCarrito productoCarrito=productoCarritoServices.getById(id);

		model.addAttribute("productoActualizar", productoCarrito);
        model.addAttribute("beneficiarioId", idBen);

		return "beneficiario/actualizar";
	}

    @PostMapping(value = "/producto/actualizar")
	public String ActualizarProducto(@ModelAttribute("productoActualizar") ProductoCarrito productoActualizar,RedirectAttributes redirectAttributes ) {


		ProductoCarrito productoCarrito=productoCarritoServices.getById(productoActualizar.getId());
		if(productoCarrito.getCantidadSeleccionada()!=productoActualizar.getCantidadSeleccionada()) {

			productoCarrito.setCantidadSeleccionada(productoActualizar.getCantidadSeleccionada());
			productoCarritoServices.actualizarProducto(productoCarrito);
			redirectAttributes.addFlashAttribute("msj","Se ha actualizado un producto de la canasta de donacion");
		}

        System.out.println(productoActualizar.getBeneficiario().getId());

         // Agregar el id del beneficiario a los redirectAttributes
        redirectAttributes.addFlashAttribute("beneficiarioId", productoActualizar.getBeneficiario().getId());


		return "redirect:/donacion/albergue/elcarrito";
	}


    @GetMapping( value = "/elcarrito/{beneficiarioId}/eliminar/{id}")
	public String vistaElimnar(@PathVariable("id")Long id, @PathVariable("beneficiarioId")Long idBen, Model model) {;

		ProductoCarrito productoCarrito=productoCarritoServices.getById(id);
		model.addAttribute("productoEliminar", productoCarrito);
        model.addAttribute("beneficiarioId", idBen);

		return "beneficiario/eliminar";
	}


	@GetMapping( value = "/elcarrito/eliminar")
	public String vistaAgregarAlCarrito(@ModelAttribute("productoEliminar") ProductoCarrito productoEliminar,RedirectAttributes redirectAttributes ) {
		System.out.println(productoEliminar.getId());

		productoCarritoServices.eliminarProducto(productoEliminar);
		redirectAttributes.addFlashAttribute("msjEliminado", "Se ha eliminado un producto de la canasta de donacion");

         redirectAttributes.addFlashAttribute("beneficiarioId", productoEliminar.getBeneficiario().getId());

		return "redirect:/donacion/albergue/elcarrito";
	}

    @GetMapping( value = "/editar")
	public String editarAlbergue(Model model) {
        Albergue albergue = albergueService.getById(1L);
        /*Albergue albergue = new Albergue();
        albergue.setNombre("Albergue Esperanza");
        albergue.setDireccion("123 Calle Ficticia, Ciudad");
        albergue.setImagen("/images/albergue.jpg");
        albergue.setLatitud(40.730610); // Ejemplo de latitud
        albergue.setLongitud(-73.935242); // Ejemplo de longitud
        albergue.setCapacidad(100);*/

        model.addAttribute("albergue", albergue);
        model.addAttribute("apiKey", "r3NiLHgrItLbXSqA7eh4");

        return "beneficiario/albergue";
    }

     @PostMapping("/updateAlbergue")
    public String updateAlbergue(@RequestParam("nombre") String nombre,
                                 @RequestParam("descripcion") String descripcion,
                                 @RequestParam("email") String email,
                                 @RequestParam("telefono") String telefono,
                                 @RequestParam("capacidad") int capacidad,
                                 @RequestParam("longitud") double longitud,
                                 @RequestParam("latitud") double latitud,
                                 Model model) {
        Albergue albergue = albergueService.getById(1L);
        albergue.setNombre(nombre);
        albergue.setDescripcion(descripcion);
        albergue.setEmail(email);
        albergue.setTelefono(telefono);
        albergue.setCapacidad(capacidad);
        albergue.setLongitud(longitud);
        albergue.setLatitud(latitud);
        albergueService.updateAlbergue(albergue);
        model.addAttribute("albergue", albergue);
        return "redirect:/donacion/albergue/editar";
    }

    @PostMapping("/rutaParaEnviarDatos")
    public String recibirDatosDeCarrito(
            @RequestParam("fecha") String fecha,
            @RequestParam("hora") String hora,
            @RequestParam("latitud") double latitud,
            @RequestParam("longitud") double longitud,
            @RequestParam("direccion") String direccion,
            @RequestParam("productos") String productosJson, // Suponiendo que los productos vienen en formato JSON
            RedirectAttributes redirectAttributes) {

        // Aquí puedes convertir el JSON de productos a objetos Java, manejar los datos, etc.
        // Supongamos que guardas los datos y rediriges a otra página para confirmar.

        return "redirect:/paginaDeConfirmacion";
    }


}
