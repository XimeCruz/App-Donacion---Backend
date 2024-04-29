package com.example.donacion.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.donacion.model.ProductoStock;
import com.example.donacion.repository.ProductoStockRepository;
import com.example.donacion.service.ProductoStockService;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/productos")
public class ProductoStockController {
    @Autowired
    private ProductoStockService productoStockService;

    @Autowired
    private ProductoStockRepository productoStockRepository;

    @GetMapping("/confirmarProducto")
    public String confirmarProducto(Model model, @RequestParam Long productoId) {
        productoStockService.confirmarProducto(productoId);
        model.addAttribute("mensaje", "Producto confirmado con éxito");
        return "resultado";
    }

    @GetMapping
    public String listarProductos(Model model) {
        List<ProductoStock> listaProductos = productoStockRepository.findAll();
        model.addAttribute("productos", listaProductos);
        return "productos"; // nombre del archivo HTML de Thymeleaf
    }

    @Transactional
    @PostMapping("/aceptar/{id}")
    public String aceptarProducto(@PathVariable Long id) {
        ProductoStock producto = productoStockRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setConfirmado(true);
            productoStockRepository.save(producto);
        }
        return "redirect:/productos";
    }

    @Transactional
    @PostMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        ProductoStock producto = productoStockRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setConfirmado(false);
            productoStockRepository.save(producto);
        }
        return "redirect:/productos";
    }
}
