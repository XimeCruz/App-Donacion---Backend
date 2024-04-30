package com.example.donacion.service;

import com.example.donacion.model.Actividad;
import com.example.donacion.repository.ActividadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActividadService {

     @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> findAll() {
        return actividadRepository.findAll();
    }

    public Actividad save(Actividad activity) {
        return actividadRepository.save(activity);
    }
}
