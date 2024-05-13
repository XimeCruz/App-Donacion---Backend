package com.example.donacion.service;


import com.example.donacion.model.ProductoCarrito;
import com.example.donacion.model.Usuario;
import com.example.donacion.repository.ProductoCarritoRepository;
import com.example.donacion.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoCarritoRepository productoCarritoRepository;
    @Autowired
    private UsuarioService usuarioService;


    public void crearCuenta(Usuario cliente) {
        usuarioRepository.save(cliente);
    }


    public Boolean existsByEmail(String email) {
        return usuarioRepository.existsByCorreoElectronico(email);
    }

    public List<ProductoCarrito> getProductosBybBeneficiario(Long id) {
        Usuario beneficiario = new Usuario();
        beneficiario.setId(id);
        return productoCarritoRepository.findByBeneficiario(beneficiario);
    }

    public Usuario GetbyEmail(String email) {

        return usuarioRepository.findByCorreoElectronico(email);
    }

    //public boolean buscarProductoStockEnCarritoCliente(Long id, Authentication authentication) {

    public boolean buscarProductoStockEnCarritoCliente(Long id, Long idBeneficiario) {

        Usuario beneficiario = usuarioService.obtenerUsuarioPorId(idBeneficiario);

        return usuarioRepository
                .findByCorreoElectronico(beneficiario.getCorreoElectronico())
                .getProductoCarritos()
                .stream()
                .filter(p ->p.getProductoStock()
                        .getId()==id)
                .findFirst()
                .isPresent();
    }

}
