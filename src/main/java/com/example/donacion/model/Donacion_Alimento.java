package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class Donacion_Alimento {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Donacion donacion;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Alimento alimento;

    private Date fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Donacion getDonacion() {
        return donacion;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
