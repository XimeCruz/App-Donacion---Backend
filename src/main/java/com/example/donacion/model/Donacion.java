package com.example.donacion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
@Table
@Entity
public class Donacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private int cantidad;
    private Date fecha_adquisicion;
    private String hora_adquisicion;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoStock producto;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "donante_id")
    private Usuario donante;

    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    private Usuario voluntarioRecojo;

}
