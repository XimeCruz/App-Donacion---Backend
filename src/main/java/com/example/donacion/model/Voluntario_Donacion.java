package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table
@Entity
public class Voluntario_Donacion {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Voluntario voluntario;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Donacion donacion;

    private Date fecha;
}
