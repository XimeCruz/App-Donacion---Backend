package com.example.donacion.service;

import com.example.donacion.model.Categoria;
import com.example.donacion.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

        @Autowired
        private CategoriaRepository categoriaRepository;


        public Categoria getById(Long id) {
            return categoriaRepository.findById(id).orElse(null);
        }

        public List<Categoria> getCategoriasAsc() {
            return categoriaRepository.findAll(Sort.by(Sort.Direction.ASC,"nombre"));
        }

}
