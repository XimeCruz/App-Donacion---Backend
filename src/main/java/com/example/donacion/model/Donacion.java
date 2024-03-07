package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Table
@Entity
public class Donacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private int cantidad;
    private Date fecha_adquisicion;
    private String hora_adquisicion;


}
