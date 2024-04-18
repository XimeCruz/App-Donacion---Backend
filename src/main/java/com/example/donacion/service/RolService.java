package com.example.donacion.service;


import com.example.donacion.model.Rol;
import com.example.donacion.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {



    @Autowired
    private RolRepository roleRepository;


    public Rol getById(Long id) {

        return roleRepository.findById(id)
                .orElse(null);
    }

    public List<Rol> getRoles() {

        return roleRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

}
