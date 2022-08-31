package com.nery.store.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O campo Título não pode estar vazio!!")
    @Length(min = 3, max = 100, message = "O campo Título deve ter entre 3 e 100 caracteres!!")
    private String titulo;

    @NotEmpty(message = "O campo Nome do Autor não pode estar vazio!!")
    @Length(min = 3, max = 200, message = "O campo Nome do Autor deve ter entre 3 e 200 caracteres!!")
    private String descricao;

    // @NotEmpty(message = "O campo Preço não pode estar vazio!!")
    // private BigDecimal  preco;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto() {
        super();
    }

    public Produto(Integer id, String titulo, String descricao, /* BigDecimal preco, */ Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        // this.preco = preco;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // public BigDecimal  getPreco() {
    //     return preco;
    // }

    // public void setPreco(BigDecimal  preco) {
    //     this.preco = preco;
    // }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }    

    
}
