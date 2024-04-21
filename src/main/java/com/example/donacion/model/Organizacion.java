package com.example.donacion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
public class Organizacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String nombre_org;
    private String ubicacion;
    private String tipo_org;
    private String tipo_alimento;
    private String area_servicio;



}
