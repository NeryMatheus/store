package com.nery.store.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nery.store.domain.Categoria;

public class CategoriaDTO implements Serializable{
    
    private Integer Id;

    @NotEmpty(message = "Campo nome não pode estar nulo!")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres!")
    private String nome;

    @NotEmpty(message = "Campo descrição não pode estar nulo!")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres!")
    private String desc;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria cat) {
        Id = cat.getId();
        this.nome = cat.getNome();
        this.desc = cat.getDesc();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
