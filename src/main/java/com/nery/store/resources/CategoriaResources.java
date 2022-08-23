package com.nery.store.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nery.store.domain.Categoria;
import com.nery.store.dtos.CategoriaDTO;
import com.nery.store.service.CategoriaService;

@CrossOrigin("*") //A requisição /livros pode receber requisições de diversas outras fontes
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @Autowired
    private CategoriaService categoriaService;

    /**
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /* Categoria DTO */
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria cat){
        cat = categoriaService.create(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
 