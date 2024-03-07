package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Alimento {
    @Id
    @Column(name = "id", nullable = false)
    private long id_alimento;
    private String tipo;
    private Date fechaVenc;
    private int cantidad;
    private String estado;

    public long getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(long id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "id_alimento=" + id_alimento +
                ", tipo='" + tipo + '\'' +
                ", fechaVenc=" + fechaVenc +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                '}';
    }
}
