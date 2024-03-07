package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table
@Entity
public class Solicitud {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String tipo_ap;
    private Date fecha_prog;
    private String hora_prog;



}
