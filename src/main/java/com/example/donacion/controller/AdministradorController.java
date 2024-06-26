package com.example.donacion.controller;


import com.example.donacion.model.ProductoCarrito;
import com.example.donacion.model.ProductoStock;
import com.example.donacion.model.Usuario;
import com.example.donacion.service.CategoriaService;
import com.example.donacion.service.ClienteService;
import com.example.donacion.service.ProductoCarritoService;
import com.example.donacion.service.ProductoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/donacion/administrador")
public class AdministradorController {

    @Autowired
    private ProductoStockService productoStockServices;

    @Autowired
    private ClienteService clienteServices;

    @Autowired
    private ProductoCarritoService productoCarritoServices;


    @Autowired
    private CategoriaService categoriaServices;


    private final String vistaAgregaralcarrito="vistascompradores/agregaralcarrito";
    private final String vistaActualizar="vistascompradores/actualizar";
    private final String carrito="vistascompradores/carrito";
    private  final String redirectAlCarrito="redirect:/donacion/beneficiario/elcarrito";
    private  final String msjActualizado="Se ha actualizado un producto de la canasta de donacion";
    private final String vistaEliminar="vistascompradores/eliminar";
    private static final String msjAgregado="Se ha agregado un nuevo producto a la canasta de donacion";
    private static final String msjProductoEncontrado="El producto ya se encuentra agregado a la canasta de donacion";
    private static final String msjProductoEliminado="Se ha eliminado un producto de la canasta de donacion";
    private final String vistaInformacionProducto ="vistascompradores/informacionproducto";




    /**
     * busca los el listado de ProductoCarrito asociado al Usuario con id y
     * devuelve la pagina carrito de compras con las lista de productos.
     *
     * @param id identificador del producto en carrito
     * @param model contiene los atributos de las vistas.
     * @return la pagina carrito de compras con el listado de productos del cliente con id.
     */
    @GetMapping( value = "/elcarrito")
    public String alCarrito(Authentication authentication, Model model) {

        //Usuario cliente=clienteServices.GetbyEmail(authentication.getName());

        Usuario cliente=clienteServices.GetbyEmail("Admin@gmail.com");

        List<ProductoCarrito> productosCarrito=cliente.getProductoCarritos();
        model.addAttribute("ProductosCarrito", productosCarrito);

        return "vistascompradores/carrito";
    }



    /**
     * busca un productoStock por id y devuelve una pagina para agregar el producto al carrito de compras de un Usuario.
     *
     * @param id identificador del productoStock que se va a agregar al carrito de compras de un cliente.
     * @param model contiene los atributos de las vistas.
     * @return la vista para agregar el producto al carrito de compras.
     */
    @GetMapping( value = "/producto/agregar/{id}")
    public String vistaAgregarAlCarrito(ProductoCarrito productoCarrito, @PathVariable("id")Long id, Model model) {

        ProductoStock productoStock=productoStockServices.getById(id);

        model.addAttribute("productoAgregar",productoStock);

        return vistaAgregaralcarrito;
    }


    /**
     *
     * @param productoCarrito sera el producto que se va a agregar al carrito
     * @param bindingResult
     * @param auth autenticador de usuario para obtener el nombre los datos del cliente en la sesion
     * @param redirectAttributes contiene atributos de redireccion de paginas.
     * @return la vista del carrito de compras del cliente actual en la sesion.
     */
    @PostMapping(value = "/producto/agregar")
    public String AgregarProductoAlCarrito(ProductoCarrito productoCarrito, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if(bindingResult.hasErrors()) {
            return vistaAgregaralcarrito;
        }

        else {
            //if(clienteServices.buscarProductoStockEnCarritoCliente(productoCarrito.getProductoStock().getId(), auth)) {
            if(clienteServices.buscarProductoStockEnCarritoCliente(productoCarrito.getProductoStock().getId(), Long.valueOf(9))) {
                redirectAttributes.addFlashAttribute("msjIntentoDeAgregado", msjProductoEncontrado);
            }
            else {
                //productoCarritoServices.guardarProducto(productoCarrito, auth);
                Usuario cliente=clienteServices.GetbyEmail("Admin@gmail.com");
                productoCarrito.setBeneficiario(cliente);
                productoCarritoServices.guardarProducto(productoCarrito);
                redirectAttributes.addFlashAttribute("msj", msjAgregado);
            }

            return  redirectAlCarrito;
        }

    }



    /**
     * Busca un ProductoCarrito por id que sera actualizado y lo agrega al modelo.
     *
     * @param id identificador del producto en carrito que se va a eliminar.
     * @param model contiene los atributos de las vistas.
     * @return la vista que contiene la informacion del producto que sera eliminado
     */
    @GetMapping( value = "/elcarrito/{id}/eliminar")
    public String vistaElimnar(@PathVariable("id")Long id, Model model) {;

        ProductoCarrito productoCarrito=productoCarritoServices.getById(id);
        model.addAttribute("productoEliminar", productoCarrito);


        return vistaEliminar;
    }

    /**
     * Elimina un ProductoCarrito de un cliente.
     *
     * @param productoEliminar recibe el producto que contiene el id del producto que será eliminado
     * @param redirectAttributes contiene atributos de redireccion de paginas.
     * @return devuelve la pagina carrito de compras con las lista de producto.
     */
    @GetMapping( value = "/elcarrito/eliminar")
    public String vistaAgregarAlCarrito(@ModelAttribute("productoEliminar") ProductoCarrito productoEliminar, RedirectAttributes redirectAttributes ) {
        System.out.println(productoEliminar.getId());

        productoCarritoServices.eliminarProducto(productoEliminar);
        redirectAttributes.addFlashAttribute("msjEliminado", msjProductoEliminado);

        return redirectAlCarrito;
    }



    /**
     * Busca un ProductoCarrito por id que sera eliminado y lo agrega al modelo.
     *
     * @param id identificador del producto en carrito que se va a actualizar.
     * @param model contiene los atributos de las vistas.
     * @return la vista que contiene la informacion del producto que sera actualizado
     */
    @GetMapping( value = "/elcarrito/actualizar/{id}")
    public String vistaActualizar(@PathVariable("id")Long id, Model model) {;

        ProductoCarrito productoCarrito=productoCarritoServices.getById(id);

        model.addAttribute("productoActualizar", productoCarrito);

        return vistaActualizar;
    }

    /**
     * Actualiza un ProductoCarrito teniendo en cuenta el id del producto y redirecciona al carrito de compras de un cliente.
     *
     * @param productoActualizar recibe el producto que contiene los datos que se van a actualizar de un producto en la base de datos.
     * @param redirectAttributes contiene atributos de redireccion de paginas.
     * @return la pagina carrito de compras con el listado de productos.
     */
    @PostMapping(value = "/producto/actualizar")
    public String ActualizarProducto(@ModelAttribute("productoActualizar") ProductoCarrito productoActualizar,RedirectAttributes redirectAttributes ) {


        ProductoCarrito productoCarrito=productoCarritoServices.getById(productoActualizar.getId());
        if(productoCarrito.getCantidadSeleccionada()!=productoActualizar.getCantidadSeleccionada()) {

            productoCarrito.setCantidadSeleccionada(productoActualizar.getCantidadSeleccionada());
            productoCarritoServices.actualizarProducto(productoCarrito);
            redirectAttributes.addFlashAttribute("msj",msjActualizado);
        }


        return redirectAlCarrito;



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
    }




}
