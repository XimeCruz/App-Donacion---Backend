package com.example.donacion.service;

import com.example.donacion.model.User;
import com.example.donacion.model.request.AuthenticationRequest;
import com.example.donacion.model.response.AuthenticationResponse;
import com.example.donacion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    //proceso de login
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authRequest) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()
        );

        authenticationManager.authenticate(authToken);

        User user = userRepository.findByUsername(authRequest.getUsername())
                        .orElseThrow(() -> new RuntimeException("User not found"));

        //en el caso de que estyoy seguro de qsurgir una excepcion no se ejcutara
        //User user = userRepository.findByUsername(authRequest.getUsername()).get();

        //se manda el objeto y los claims
        //crear el body
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        AuthenticationResponse.Body bodyRes = new AuthenticationResponse.Body();
        bodyRes.setAccessToken(jwt);
        bodyRes.setRefreshToken(jwt);

        AuthenticationResponse.User userRes = new AuthenticationResponse.User();
        userRes.setUsername(user.getUsername());
        userRes.setName(user.getName());
        userRes.setId(String.valueOf(user.getId()));

        bodyRes.setUser(userRes);


        //claims data en https://jwt.io/

        return new AuthenticationResponse(HttpStatus.OK.value(),bodyRes);
    }

    private Map<String, Object> generateExtraClaims(User user) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName()); //claim
        extraClaims.put("role", user.getRole().name()); //claim
        extraClaims.put("permissions", user.getAuthorities()); //EXTRA

        return extraClaims;
    }


}
