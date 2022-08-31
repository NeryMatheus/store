package com.nery.store.dtos;

import java.io.Serializable;

import com.nery.store.domain.Produto;

public class ProdutoDTO implements Serializable{
    private Integer id;
    private String title;

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.title = produto.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }    
     
}
