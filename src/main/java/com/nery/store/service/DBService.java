package com.nery.store.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.store.domain.Categoria;
import com.nery.store.domain.Produto;
import com.nery.store.repositories.CategoriaRepository;
import com.nery.store.repositories.ProdutoRepository;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    
    /**
     * 
     */
    public void instanciaBasedeDados(){
        Categoria cat1 = new Categoria(null, "Informática", "Componentes eletrônicos");
        Categoria cat2 = new Categoria(null, "Aquático", "Produtos para limpeza de piscinas");
        Categoria cat3 = new Categoria(null, "Música", "Artigos para produção musical");

        Produto p1 = new Produto(null, "TV 42 Polegadas", "TV 42 Polegadas", 3500, cat1);
        Produto p2 = new Produto(null, "Mouse", "Mouse Logitech", 52.5, cat1);
        Produto p3 = new Produto(null, "Teclado", "Teclado Logitech", 82.9, cat1);
        Produto p4 = new Produto(null, "Filtro de água", "Filtro de água", 99, cat2);
        Produto p5 = new Produto(null, "Cloro", "Cloro", 120, cat2);
        Produto p6 = new Produto(null, "Guitarra", "Guitarra", 790, cat3);
        Produto p7 = new Produto(null, "Violão", "Violão", 460, cat3);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p4, p5));
        cat3.getProdutos().addAll(Arrays.asList(p6, p7));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));

    }
}
