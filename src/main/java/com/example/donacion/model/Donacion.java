package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Donacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id_donacion;
    private int cantidad;
    private Date fecha_adquisicion;
    private String hora_adquisicion;

    public long getId_donacion() {
        return id_donacion;
    }

    public void setId_donacion(long id_donacion) {
        this.id_donacion = id_donacion;
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

    @Override
    public String toString() {
        return "Donacion{" +
                "id_donacion=" + id_donacion +
                ", cantidad=" + cantidad +
                ", fecha_adquisicion=" + fecha_adquisicion +
                ", hora_adquisicion='" + hora_adquisicion + '\'' +
                '}';
    }
}
