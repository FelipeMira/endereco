package com.fiap.grupo.dois.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.fiap.grupo.dois.model.Endereco;

public interface EnderecoRepository extends Repository<Endereco, String> {
	 
    void delete(Endereco deleted);
    
    List<Endereco> findAll();
 
    Optional<Endereco> findById(String id);
 
    Endereco save(Endereco saved);
}
