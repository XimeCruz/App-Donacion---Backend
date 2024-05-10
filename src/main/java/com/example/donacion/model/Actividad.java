package com.example.donacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "actividad")
@NoArgsConstructor
@AllArgsConstructor
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreProducto;
    private int cantidad;
    private Date fecha;

}
