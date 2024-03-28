package com.example.donacion.model.response;

import org.springframework.http.HttpStatus;

public class AuthenticationResponse {
    private int statuscode;
    private Body body;

    // Getters y setters
    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    // Clase interna para el cuerpo de la respuesta
    public static class Body {
        private String accessToken;
        private String refreshToken;
        private User user;

        // Getters y setters
        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // Clase interna para el usuario
    public static class User {
        private String username;
        private String name;
        private String id;

        // Getters y setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }


    public AuthenticationResponse(int statuscode, Body body) {
        this.statuscode = statuscode;
        this.body = body;
    }
}

