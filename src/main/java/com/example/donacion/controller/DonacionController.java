package com.example.donacion.controller;

import com.example.donacion.model.Donacion;
import com.example.donacion.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donaciones")
public class DonacionController {
    
    @Autowired
    private DonacionService donacionService;

    @GetMapping
    public ResponseEntity<List<Donacion>> getAllDonacions() {
        List<Donacion> donacions = donacionService.getAllDonacions();

        System.out.println(donacions);
        return new ResponseEntity<>(donacions, HttpStatus.OK);
    }

    @GetMapping(value ="{id}")
    public ResponseEntity<Donacion> getDonacionById(@PathVariable Integer id) {
        Donacion Donacion = donacionService.getDonacionById(id);
        if (Donacion != null) {
            return new ResponseEntity<>(Donacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Donacion> createDonacion(@RequestBody Donacion Donacion) {
        Donacion nuevaDonacion = donacionService.saveDonacion(Donacion);
        return new ResponseEntity<>(nuevaDonacion, HttpStatus.CREATED);
    }

    // Endpoint para actualizar una Donacion existente
    @PutMapping(value="{id}")
    public ResponseEntity<Donacion> updateDonacion(@PathVariable Long id, @RequestBody Donacion Donacion) {
        Donacion DonacionActualizada = donacionService.updateDonacion(id, Donacion);
        if (DonacionActualizada != null) {
            return new ResponseEntity<>(DonacionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una Donacion por su ID
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteDonacion(@PathVariable Long id) {
        donacionService.deleteDonacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ascendente")
    public ResponseEntity<List<Donacion>> obtenerDonacionsAscendente() {
        List<Donacion> Donacions = donacionService.getDonacionsAsc();
        return new ResponseEntity<>(Donacions, HttpStatus.OK);
    }
}
