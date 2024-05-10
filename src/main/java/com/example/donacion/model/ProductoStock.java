package com.example.donacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.util.List;


@ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "productos_stock")
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ProductoStock {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre	")
	@NotEmpty(message = "Falta rellenar el campo nombre")
	private String nombre;
	
	@Column(name = "descripcion",length = 7000)
	@NotEmpty(message = "Falta rellenar el campo descripción")
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name = "IdCategoria")
	private Categoria categoria;
	
	
	@Column(name = "cantidadDisponible")
	@Min(value = 1,message = "la cantidad de unidades disponibles debe ser por lo menos 1 " )
	@NotNull(message = "Falta rellenar el campo unidades disponibles ")
	private Integer unidadesDisponibles;
	
	
	@Column(name = "fechaPublicacion")
	private Date fechaDePublicacion;

	@Column(name = "fechaVencimiento")
	private Date fechaDeVencimiento;

	@Column(name = "imagen")
	private String imagen;
	
	/**
	 * Identifica el vendedor que ha publicado este producto en la tienda.
	 * Cada ProductoStock solo puede tener un Vendedor. 
	 */
	@ManyToOne
	@JoinColumn(name = "IdDonante")
	private Usuario donante;
	
	// private String estado; // Nuevo, Usado, etc.
    private boolean confirmado = false;

	/**
	 * lista de Productos que han sido agregado en el carrito de compras y hacen referencia a este producto de la tienda.
	 */
	@OneToMany(mappedBy = "productoStock",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<ProductoCarrito> posiblescompras;
}
