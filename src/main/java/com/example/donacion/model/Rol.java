package com.example.donacion.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;


@ToString
@Entity
@Table(name = "rol")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Rol implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	/**
	 *Representa una lista de Vendedor que contiene todos los usuarios en una base de datos cuyo rol sea de tipo Vendedor. 
	 */
	@OneToMany(mappedBy = "rol",cascade = {CascadeType.REMOVE})
	private List<Usuario> usuarios;

	@Override
	public String getAuthority() {
		
		return nombre;
	}
	
	
}
