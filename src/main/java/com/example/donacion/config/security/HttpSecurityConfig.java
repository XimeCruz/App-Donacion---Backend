package com.example.donacion.config.security;

import com.example.donacion.config.security.filter.JwtAuthenticationFilter;
import com.example.donacion.util.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableMethodSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf( csrfConfig -> csrfConfig.disable() ) //desabilitar par alo de la vulnerabilidad web
                .sessionManagement( sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS) )
                .authenticationProvider(authenticationProvider)
                //filtro GRWEGdo de la clase antes de la cual se debe agregar
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(builderRequestMatchers()) //le decimos que endpoitn son publicos
        ;

        return http.build();
    }

    private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> builderRequestMatchers() {
        return authConfig -> {
            //poner las rutas

            authConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll(); //tipo publico con post
            authConfig.requestMatchers(HttpMethod.GET, "/auth/public-access").permitAll(); //tipo publico con get
            authConfig.requestMatchers(HttpMethod.POST, "/auth/signup").permitAll(); //tipo publico con get
            authConfig.requestMatchers("/error").permitAll(); //errores por defecto se muestrasn en /error aplica a todos los https
            authConfig.requestMatchers("/*").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/products").hasAuthority(Permission.READ_ALL_PRODUCTS.name()); //tods los que tengan el permiso
            authConfig.requestMatchers(HttpMethod.POST, "/products").hasAuthority(Permission.SAVE_ONE_PRODUCT.name());
            //ambos llaman a la clase usuario y al metodo getAuthorities
            authConfig.requestMatchers("/css/**","/images/**","/js/**").permitAll();
            authConfig.requestMatchers("/donacion/","/donacion/inicio","/donacion/registro")
				.anonymous();
            authConfig.anyRequest().permitAll();
            //authConfig.anyRequest().denyAll(); //cualquier peticion que no esta mapeada es decir que haymos dicho que se ública o privada se le denegara el acceso
        };
    }

}
