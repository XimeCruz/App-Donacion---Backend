package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Administrador {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String ci;


    @ManyToOne
    @JsonIgnoreProperties("")
    private Usuario usuario;
}
