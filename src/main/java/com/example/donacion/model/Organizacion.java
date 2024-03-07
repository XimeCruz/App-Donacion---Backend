package com.example.donacion.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Organizacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String nombre_org;
    private String ubicacion;
    private String tipo_org;
    private String tipo_alimento;
    private String area_servicio;

//    @OneToOne(mappedBy = "receptor", cascade = CascadeType.ALL)
//    private Receptor receptor;

    @OneToOne
    @JoinColumn(name = "receptor_id")
    private Receptor receptor;

}
