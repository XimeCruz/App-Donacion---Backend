package com.example.donacion.security.services;

import com.example.donacion.model.Usuario;
import com.example.donacion.repository.UsuarioRepository;
import com.example.donacion.security.UserDetalles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailservice implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario=usuarioRepository.findByCorreoElectronico(username);
		
		if(usuario!=null) {
			return new UserDetalles(usuario);
		}
	
		throw new UsernameNotFoundException("usuario no encontrado: "+usuario);
	}
	
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
}
