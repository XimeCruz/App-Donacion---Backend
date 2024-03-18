package com.example.donacion.util;

import java.util.Arrays;
import java.util.List;

public enum Role {

    //Asignar permisos de roles

    CUSTOMER(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    ADMINISTRATOR(Arrays.asList(Permission.SAVE_ONE_PRODUCT, Permission.READ_ALL_PRODUCTS)),
    DONANTE(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    BENEFICIARIO(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    VOLUNTARIO(Arrays.asList(Permission.READ_ALL_PRODUCTS));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
