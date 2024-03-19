package com.example.donacion.model.request;

import com.example.donacion.util.Schedule;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class SignupRequest {

    private String name;

    private String email;

    private String username;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReplaypassword() {
        return replaypassword;
    }

    public void setReplaypassword(String replaypassword) {
        this.replaypassword = replaypassword;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isOrganization() {
        return organization;
    }

    public void setOrganization(boolean organization) {
        this.organization = organization;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public String getDirectionOrganization() {
        return directionOrganization;
    }

    public void setDirectionOrganization(String directionOrganization) {
        this.directionOrganization = directionOrganization;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isAcceptClause() {
        return acceptClause;
    }

    public void setAcceptClause(boolean acceptClause) {
        this.acceptClause = acceptClause;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isTransport() {
        return transport;
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public Integer getNumberMembers() {
        return numberMembers;
    }

    public void setNumberMembers(Integer numberMembers) {
        this.numberMembers = numberMembers;
    }

    public String getRestrictAlergies() {
        return restrictAlergies;
    }

    public void setRestrictAlergies(String restrictAlergies) {
        this.restrictAlergies = restrictAlergies;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
