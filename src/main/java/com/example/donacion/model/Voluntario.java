package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Voluntario {
    @Id
    @Column(name = "id", nullable = false)
    private long idUSer;  // hay que modificar XD ya que es herencia xd

    private int edad;
    private String horario;
    private String turno;

    // falta agregar idUser getter y setter
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
}
