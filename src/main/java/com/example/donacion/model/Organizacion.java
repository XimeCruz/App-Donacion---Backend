package com.example.donacion.model;

import jakarta.persistence.*;

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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre_org() {
        return nombre_org;
    }

    public void setNombre_org(String nombre_org) {
        this.nombre_org = nombre_org;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo_org() {
        return tipo_org;
    }

    public void setTipo_org(String tipo_org) {
        this.tipo_org = tipo_org;
    }

    public String getTipo_alimento() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
    }

    public String getArea_servicio() {
        return area_servicio;
    }

    public void setArea_servicio(String area_servicio) {
        this.area_servicio = area_servicio;
    }

}
