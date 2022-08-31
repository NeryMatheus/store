package com.nery.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.store.domain.Produto;
import com.nery.store.exceptions.ObjectNotFoundExceptions;
import com.nery.store.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() ->  new ObjectNotFoundExceptions("Objeto não encontrado!! Id: " + id + ". Tipo: " + Produto.class.getName(), null));
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

}
