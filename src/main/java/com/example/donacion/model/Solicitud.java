package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class Solicitud {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String tipo_ap;
    private Date fecha_prog;
    private String hora_prog;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo_ap() {
        return tipo_ap;
    }

    public void setTipo_ap(String tipo_ap) {
        this.tipo_ap = tipo_ap;
    }

    public Date getFecha_prog() {
        return fecha_prog;
    }

    public void setFecha_prog(Date fecha_prog) {
        this.fecha_prog = fecha_prog;
    }

    public String getHora_prog() {
        return hora_prog;
    }

    public void setHora_prog(String hora_prog) {
        this.hora_prog = hora_prog;
    }

    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;


}
