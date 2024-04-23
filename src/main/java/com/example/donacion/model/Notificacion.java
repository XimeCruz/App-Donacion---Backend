package com.example.donacion.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Notificacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;


    @OneToOne
    private Producto producto;

    public Notificacion() {

    }
}
