package com.nery.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.store.domain.Categoria;
import com.nery.store.exceptions.ObjectNotFoundExceptions;
import com.nery.store.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não encontrado! Id: " + id + ". Tipo: " + Categoria.class.getName(), null));       
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria cat) {
        cat.setId(null);
        return categoriaRepository.save(cat);
    }

}
