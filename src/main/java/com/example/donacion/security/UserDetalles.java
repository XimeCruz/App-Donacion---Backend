package com.example.donacion.security;

import com.example.donacion.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetalles implements UserDetails{

	
	private static final long serialVersionUID = 1L;


    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(usuario.getRol());
	}

	@Override
	public String getPassword() {

		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		
		return usuario.getCorreoElectronico();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
	private final Usuario usuario;
}
