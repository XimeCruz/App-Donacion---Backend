package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Table
@Entity
public class Donacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private int cantidad;
    private Date fecha_adquisicion;
    private String hora_adquisicion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public String getHora_adquisicion() {
        return hora_adquisicion;
    }

    public void setHora_adquisicion(String hora_adquisicion) {
        this.hora_adquisicion = hora_adquisicion;
    }
}
