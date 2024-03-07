package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Inventario {
    @Id
    @Column(name = "id", nullable = false)
    private long id_inv;
    private Date fecha_deshecho;
    private String razon;
    private int cantidad;

    public long getId_inv() {
        return id_inv;
    }

    public void setId_inv(long id_inv) {
        this.id_inv = id_inv;
    }

    public Date getFecha_deshecho() {
        return fecha_deshecho;
    }

    public void setFecha_deshecho(Date fecha_deshecho) {
        this.fecha_deshecho = fecha_deshecho;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id_inv=" + id_inv +
                ", fecha_deshecho=" + fecha_deshecho +
                ", razon='" + razon + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
