package com.example.donacion.service;

import com.example.donacion.model.Donacion;
import com.example.donacion.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    public List<Donacion> findAll() {
        return donacionRepository.findAll();
    }
}
