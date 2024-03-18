package com.example.donacion.model.request;

import com.example.donacion.util.Schedule;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class SignupRequest {

    private String name;

    private String email;

    private String nameUser;

    private String password;

    private String replaypassword;

    private Date birthdate;

    private boolean organization;

    private String nameOrganization;

    private String directionOrganization;

    private String direction;

    private boolean acceptClause;

    private Integer phone;

    @Enumerated(EnumType.STRING)
    private Schedule schedule;

    private boolean transport;

    private Integer numberMembers;

    private String restrictAlergies;

    private String role;

}
