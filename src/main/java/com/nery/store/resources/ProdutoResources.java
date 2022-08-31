package com.nery.store.resources;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nery.store.domain.Produto;
import com.nery.store.dtos.ProdutoDTO;
import com.nery.store.service.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources implements Serializable{
    
    @Autowired
    private ProdutoService produtoService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto prod = produtoService.findById(id);
        return ResponseEntity.ok().body(prod);
    }
    
    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<Produto> list = produtoService.findAll();
        List<ProdutoDTO> listDTO = list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
