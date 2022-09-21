package com.nery.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nery.store.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    @Query("SELECT obj FROM Produto obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
    List<Produto> findProdutos(@Param(value = "id_cat") Integer id_cat);

    
}
