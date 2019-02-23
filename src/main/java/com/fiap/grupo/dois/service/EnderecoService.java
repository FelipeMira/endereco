package com.fiap.grupo.dois.service;

import java.util.List;

import com.fiap.grupo.dois.dto.EnderecoDTO;

public interface EnderecoService {
	
	EnderecoDTO create(EnderecoDTO endereco);

    EnderecoDTO delete(String id);
 
    List<EnderecoDTO> findAll();

    EnderecoDTO findById(String id);

    EnderecoDTO update(EnderecoDTO endereco);
}
