package com.fiap.grupo.dois.mongoDb;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import com.fiap.grupo.dois.error.EnderecoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.grupo.dois.dto.EnderecoDTO;
import com.fiap.grupo.dois.model.Endereco;
import com.fiap.grupo.dois.repository.EnderecoRepository;
import com.fiap.grupo.dois.service.EnderecoService;

@Service
public final class MongoDBEnderecoService implements EnderecoService {
	
	private final EnderecoRepository repository;
	 
    @Autowired
    MongoDBEnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public EnderecoDTO create(EnderecoDTO endereco) {
        Endereco persisted = Endereco.getBuilder()
                .cidade(endereco.getCidade())
                .logradouro(endereco.getLogradouro())
                .estado(endereco.getEstado())
                .numero(endereco.getNumero())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public EnderecoDTO delete(String id) {
        Endereco deleted = findEnderecoById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<EnderecoDTO> findAll() {
        List<Endereco> enderecoEntries = repository.findAll();
        return convertToDTOs(enderecoEntries);
    }
 
    private List<EnderecoDTO> convertToDTOs(List<Endereco> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
 
    @Override
    public EnderecoDTO findById(String id) {
        Endereco found = findEnderecoById(id);
        return convertToDTO(found);
    }
 
    @Override
    public EnderecoDTO update(EnderecoDTO endereco) {
        Endereco updated = findEnderecoById(endereco.getId());
        updated.update(endereco.getCidade(), endereco.getLogradouro(), endereco.getEstado(), endereco.getNumero());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Endereco findEnderecoById(String id) {
        Optional<Endereco> result = repository.findById(id);
        return result.orElseThrow(() -> new EnderecoNotFoundException(id));
 
    }
 
    private EnderecoDTO convertToDTO(Endereco model) {
        EnderecoDTO dto = new EnderecoDTO();
 
        dto.setId(model.getId());
        dto.setCidade(model.getCidade());
        dto.setLogradouro(model.getLogradouro());
        dto.setNumero(model.getNumero());
        dto.setEstado(model.getEstado());
 
        return dto;
    }
}
