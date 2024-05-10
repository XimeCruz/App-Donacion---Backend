package com.example.donacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "categoria")

@NoArgsConstructor
@AllArgsConstructor

public class Categoria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	
	
	@Column(name = "descripcion")
	private String descripcion;
	
	/*
	 *Representa una lista de ProductoStocks que contiene todos los productos en stock que asociados a esta categoria.
	 */
	@OneToMany(mappedBy = "categoria", cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<ProductoStock >productoStocks;
	
}
