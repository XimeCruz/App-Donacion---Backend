package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Administrador {
    @Id
    @Column(name = "id", nullable = false)
    private long idUSer;  // hay que modificar XD ya que es herencia xd

    private String ci;

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
}
