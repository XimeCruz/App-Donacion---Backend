package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Usuario {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    private String contrasenia;

    private String ubicacion;

    private String correo;

    private String telefono;


    @ManyToOne
    @JsonIgnoreProperties("")
    private Donacion donacion;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Solicitud solicitud;

}
