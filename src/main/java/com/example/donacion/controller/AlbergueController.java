package com.example.donacion.controller;

import com.example.donacion.model.Donacion;
import com.example.donacion.model.Notificacion;
import com.example.donacion.model.ProductoStock;
import com.example.donacion.model.response.DonacionResponse;
import com.example.donacion.service.CategoriaService;
import com.example.donacion.service.DonacionService;
import com.example.donacion.service.NotificacionService;
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

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping(value = "/productos")
    public String principal(Model model, Pageable page) {
        Page<ProductoStock> productos = productoStockServices.getProductos(page);
        model.addAttribute("productos", productos);
        model.addAttribute("isPageable", true);

        return "principal/albergue";
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
        return "principal/donaciones";
    }

    @GetMapping(value = "/producto/{id}/informacion")
    public String informacionDelProductoCarrito(@PathVariable("id") Long id, Model model) {
        ProductoStock productoStock = productoStockServices.getById(id);
        model.addAttribute("productoInfo", productoStock);
        model.addAttribute("delCarrito", true);

        return "vistascompradores/informacionproducto";
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
}
