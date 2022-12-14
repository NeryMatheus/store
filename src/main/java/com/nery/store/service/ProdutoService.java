package com.nery.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.store.domain.Categoria;
import com.nery.store.domain.Produto;
import com.nery.store.exceptions.ObjectNotFoundExceptions;
import com.nery.store.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() ->  new ObjectNotFoundExceptions("Objeto não encontrado!! Id: " + id + ". Tipo: " + Produto.class.getName(), null));
    }

    public List<Produto> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return produtoRepository.findProdutos(id_cat);
    }

    public Produto update(Integer id, Produto prod) {
        Produto newProd = findById(id);
        updateData(newProd, prod);
        return produtoRepository.save(newProd);
    }

    private void updateData(Produto newProd, Produto prod) {
        newProd.setTitulo(prod.getTitulo());
        newProd.setDescricao(prod.getDescricao());
        newProd.setPreco(prod.getPreco());
    }

    public void delete(Integer id) {
        Produto prod = findById(id);
        produtoRepository.delete(prod);
    }

    public Produto create(Integer id_prod, Produto prod) {
        prod.setId(null);
        Categoria cat = categoriaService.findById(id_prod);
        prod.setCategoria(cat);
        return produtoRepository.save(prod);
    }

}
