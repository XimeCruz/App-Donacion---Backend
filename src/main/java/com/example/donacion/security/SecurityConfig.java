package com.example.donacion.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
		
		httpSecurity.authorizeHttpRequests(http ->http
				.requestMatchers("/css/**","/images/**","/js/**")
				.permitAll()
				.requestMatchers("/donacion/","donacion/inicio","donacion/registro","donacion/**")
				.permitAll()
				.requestMatchers("donacion/principal","donacion/donacion")
								.permitAll()
				//.hasAnyAuthority("Donante","Voluntario","Beneficiario")
				.requestMatchers("donacion/beneficiario/**")
								.permitAll()
				//.hasAuthority("Beneficiario")
				.requestMatchers("donacion/donante/**")
				.hasAuthority("Donante")
				.requestMatchers("/donacion/","/donacion/inicio","/donacion/registro")
				.anonymous()
				.anyRequest()
				//.authenticated()
								.permitAll()
				)
		
		.formLogin(l-> l
				.loginPage("/donacion/home")
				.permitAll());
		
		return httpSecurity.build();
	}
	
	
	/**
	 * 
	 * @return el bean configurado para recuperar las contraseñas encriptadas.
	 */
	@Bean
	PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
}
