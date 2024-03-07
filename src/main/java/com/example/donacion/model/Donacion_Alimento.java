package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
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
}
