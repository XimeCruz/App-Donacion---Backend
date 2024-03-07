package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Solicitud {
    @Id
    @Column(name = "id", nullable = false)
    private long id_solicitud;
    private String tipo_ap;
    private Date fecha_prog;
    private String hora_prog;

    public long getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(long id_solicitud) {
        this.id_solicitud = id_solicitud;
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

    @Override
    public String toString() {
        return "Solicitud{" +
                "id_solicitud=" + id_solicitud +
                ", tipo_ap='" + tipo_ap + '\'' +
                ", fecha_prog=" + fecha_prog +
                ", hora_prog='" + hora_prog + '\'' +
                '}';
    }
}
