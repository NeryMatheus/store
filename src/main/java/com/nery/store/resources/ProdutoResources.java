package com.nery.store.resources;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nery.store.domain.Produto;
import com.nery.store.dtos.ProdutoDTO;
import com.nery.store.service.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources implements Serializable {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto prod = produtoService.findById(id);
        return ResponseEntity.ok().body(prod);
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produto> list = produtoService.findAll();
        List<ProdutoDTO> listDTO = list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @Valid @RequestBody Produto prod) {
        Produto newProd = produtoService.update(id, prod);
        return ResponseEntity.ok().body(newProd);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Produto> updatePatch(@PathVariable Integer id, @Valid @RequestBody Produto prod) {
        Produto newProd = produtoService.update(id, prod);
        return ResponseEntity.ok().body(newProd);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_prod, @Valid @RequestBody Produto prod) {
        Produto newProd = produtoService.create(id_prod, prod);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produtos/{id}").buildAndExpand(newProd.getId()).toUri();
        return ResponseEntity.created(uri).build(); 
    }

}
