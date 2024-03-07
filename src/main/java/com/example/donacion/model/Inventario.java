package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
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

}
