package com.example.donacion.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "albergue")
@NoArgsConstructor
@AllArgsConstructor

public class Albergue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private Integer beneficiarioId;
    private String telefono;
    private String email;
    private String imagen;
    private double latitud;
    private double longitud;
    private Integer capacidad;
}
