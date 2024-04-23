package com.example.donacion.service;

import com.example.donacion.model.Notificacion;
import com.example.donacion.model.Producto;
import com.example.donacion.repository.NotificacionRepository;
import com.example.donacion.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class NotificacionService {


    @Autowired
    private NotificacionRepository notificacionRepository;


    @Autowired
    private ProductoRepository productoRepository;


    public void enviarNotificacion(String mensaje) {

        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje(mensaje);
        notificacionRepository.save(notificacion);
    }

//    public void generarNotificacionesPorVencimiento() {
//        Date fechaLimite = LocalDate.now().plusWeeks(1);
//        List<Producto> productos = productoRepository.findByFechaVencBefore(fechaLimite);
//        for (Producto producto : productos) {
//            String mensaje = "El producto " + producto.getNombre() + " vencerá pronto.";
//            Notificacion notificacion = new Notificacion();
//            notificacion.setMensaje(mensaje);
//            notificacion.setProducto(producto);
//            notificacionRepository.save(notificacion);
//        }
//    }
}
