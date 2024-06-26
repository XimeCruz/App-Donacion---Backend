package com.example.donacion.model;

import com.example.donacion.validators.Password;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;



@ToString
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El campo nombre no puede estar en blanco")
	@Size(min = 5, max = 45,message = "El campo nombre no esta bien")
	@NotEmpty(message = "El campo nombre no puede estar vacio")
	@Column(name = "nombre")
	private String nombre;
	
	
	@NotBlank(message = "El campo nombre de usuario no puede estar en blanco")
	@NotEmpty(message = "El campo nombre de usuario no puede estar vacio")
	@Column(name = "nombre de usuario")
	private String nombreUsuario;
	
	
	@NotBlank(message = "El campo correo electronicoe no puede estar en blanco")
	@NotEmpty(message = "El campo correo electronico no puede estar vacio")
	@Column(name = "correoElectronico")
	@Email
	private String correoElectronico;
	
	@NotBlank
	//@Pattern(regexp = "\\d{10}")
	private String telefono;	
	
	@Password
	@NotBlank(message = "El campo contraseña no puede estar en blanco")
	@NotEmpty(message = "El campo contraseña no puede estar vacio")
	@Column(name = "password")
	private String password;
	
	
	@Password
	@Transient
	@NotBlank(message = "El campo  verificación de contraseña no puede estar en blanco")
	@NotEmpty(message = "El campo verificación de contraseña no puede estar vacio")
	private String passwordValid;

	@Column(columnDefinition = "integer default 1")
	private Integer activo;
	
	
	@NotNull(message = "El campo fecha de nacimiento no puede estar vacio")
	@Column(name = "fecha de nacimiento")
	private Date fechaDeNacimiento;


	private String direccion;
	
	/**
	 *Identifica el rol de un usuario en la entidad usuarios en la base de datos. 
	 *el rol es identificado a traves de un id.
	 */
	@ManyToOne()
	@JoinColumn(name = "IdRol" )
	private Rol rol;
	
	
	
	/*
	 *Representa una lista de ProductoStock que contiene todos los productos en stock que pertenecen a el Vendedor.
	 * 
	 */
	@OneToMany(mappedBy = "donante",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<ProductoStock>productoStocks;
	
	
	/*
	 *Representa una lista de ProductoCarrito que contiene todos los productos en carrito que pertenecen a el Cliente.
	 * 
	 */
	@OneToMany(mappedBy = "beneficiario",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<ProductoCarrito> productoCarritos;
	
	
	
	
	/**
	 * verifica si la contraseña y la verificacion de contraseña son iguales.
	 * 
	 * @return true si son iguales o falso si no.
	 */
	public Boolean validPasword() {
		
		return password.equals(passwordValid);
	}
	
	public Boolean esMayordeEdad() {
		LocalDate fechaNacimiento=fechaDeNacimiento.toLocalDate();
		Period periodo=Period.between(fechaNacimiento, LocalDate.now());
		
		return periodo.getYears()>=18;
	}
}
