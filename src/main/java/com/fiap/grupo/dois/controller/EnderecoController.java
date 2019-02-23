package com.fiap.grupo.dois.controller;

import java.util.List;

import javax.validation.Valid;

import com.fiap.grupo.dois.error.EnderecoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.grupo.dois.dto.EnderecoDTO;
import com.fiap.grupo.dois.service.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	private final EnderecoService service;
	 
    @Autowired
    EnderecoController(EnderecoService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    EnderecoDTO create(@RequestBody @Valid EnderecoDTO enderecoEntry) {
        return service.create(enderecoEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    EnderecoDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<EnderecoDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    EnderecoDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    EnderecoDTO update(@RequestBody @Valid EnderecoDTO enderecoEntry) {
        return service.update(enderecoEntry);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(EnderecoNotFoundException ex) {
    }
}
