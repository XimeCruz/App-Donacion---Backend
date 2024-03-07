package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Receptor {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Usuario usuario;

//    @OneToOne
//    @JoinColumn(name = "organizacion_id")
//    private Organizacion organizacion;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "receptor")
    private Organizacion organizacion;
    
}
