package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table
@Entity
public class Alimento {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String tipo;
    private Date fechaVenc;
    private int cantidad;
    private String estado;


}
