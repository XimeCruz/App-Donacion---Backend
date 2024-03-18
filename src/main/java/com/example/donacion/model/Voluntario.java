package com.example.donacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Table
@Entity
public class Voluntario {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private int edad;
    private String horario;
    private String turno;


    @ManyToOne
    @JsonIgnoreProperties("")
    private User usuario;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
