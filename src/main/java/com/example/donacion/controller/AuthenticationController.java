package com.example.donacion.controller;

import com.example.donacion.model.User;
import com.example.donacion.model.request.AuthenticationRequest;
import com.example.donacion.model.request.SignupRequest;
import com.example.donacion.model.response.AuthenticationResponse;
import com.example.donacion.model.response.MessageResponse;
import com.example.donacion.repository.UserRepository;
import com.example.donacion.service.AuthenticationService;
import com.example.donacion.util.Role;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationService authenticationService;

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("permitAll")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Valid AuthenticationRequest authRequest){

        AuthenticationResponse jwtDto = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/public-access")
    public String publicAccessEndpoint(){
        return "este endpoint es público";
    }


//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(new JwtResponse(jwt,
//                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
//    }
//

    @PreAuthorize("permitAll")
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }


        String strRol = signUpRequest.getRole();

        Role userRole = Role.CUSTOMER;

        switch (strRol) {
            case "admin":
                userRole = Role.ADMINISTRATOR;
                break;
            case "ben":
                userRole = Role.BENEFICIARIO;
                break;
            case "don":
                userRole = Role.DONANTE;
                break;
            case "vol":
                userRole = Role.VOLUNTARIO;
                break;
        }


        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getName(),
                passwordEncoder.encode(signUpRequest.getPassword()),
                signUpRequest.getDirection(),
                signUpRequest.getEmail(),
                signUpRequest.getPhone(),
                userRole
        );

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}
