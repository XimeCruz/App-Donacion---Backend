package com.example.donacion.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonacionResponse {

    private String fechaAdquisicion;
    private int cantidad;
    private String nombreProducto;
    private String nombreOrganizacion;
    private String nombreDonante;
    private String nombreVoluntarioRecojo;

}
