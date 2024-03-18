package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class Inventario {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private Date fecha_deshecho;
    private String razon;
    private int cantidad;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Alimento alimento;


    @ManyToOne
    @JsonIgnoreProperties("")
    private Producto producto;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
