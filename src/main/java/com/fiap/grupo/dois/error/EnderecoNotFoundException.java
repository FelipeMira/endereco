package com.fiap.grupo.dois.error;

@SuppressWarnings("serial")
public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException(String id) {
        super(String.format("Nenhum endereco encontrado pelo id: <%s>", id));
    }
}
