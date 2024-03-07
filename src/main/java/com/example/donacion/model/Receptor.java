package com.example.donacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Receptor {
    @Id
    @Column(name = "id", nullable = false)
    private long idUSer;  // hay que modificar XD ya que es herencia xd
}
