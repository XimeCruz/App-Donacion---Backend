package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Table
@Entity
public class Receptor {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JsonIgnoreProperties("")
    private User usuario;

//    @OneToOne
//    @JoinColumn(name = "organizacion_id")
//    private Organizacion organizacion;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "receptor")
    private Organizacion organizacion;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
