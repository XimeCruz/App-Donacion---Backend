package com.example.donacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DonacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonacionApplication.class, args);
    }

    //encriptamos nuestro password

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    //despues de que el proyecto sea ejecutado
//    @Bean
//    public CommandLineRunner createPasswordsCommand(){
//        return args -> {
//            //para codear o generar las contraseñas
//            System.out.println(passwordEncoder.encode("clave123"));
//            System.out.println(passwordEncoder.encode("clave456"));
//        };
//    }

}
