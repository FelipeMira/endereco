package com.fiap.grupo.dois.model;

import static util.PreCondition.isTrue;
import static util.PreCondition.notEmpty;
import static util.PreCondition.notNull;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public final class Endereco {

    public static final int MAX_LENGTH_LOGRADOURO = 500;
    public static final int MAX_LENGTH_CIDADE = 100;
    public static final int MAX_LENGTH_ESTADO = 2;
    
	@Id
    private String id;
	private String cidade;
	private String logradouro;
	private String estado;
	private int numero;
	
	public Endereco() {}
	
	public Endereco(Builder builder) {
		super();
		this.cidade = builder.cidade;
		this.logradouro = builder.logradouro;
		this.estado = builder.estado;
		this.numero = builder.numero;
	}
	
	public static Builder getBuilder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void update(String cidade, String logradouro, String estado, int numero) {
	   checkObject(cidade, logradouro, estado, numero);

        this.cidade = cidade;
        this.logradouro = logradouro;
        this.estado = estado;
        this.numero = numero;
    }


	/**
     * We don't have to use the builder pattern here because the constructed class has only two String fields.
     * However, I use the builder pattern in this example because it makes the code a bit easier to read.
     */
    public static class Builder {

        private String cidade;
        private String logradouro;
        private String estado;
        private int numero;

        private Builder() {}

        public Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder logradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }
        
        public Builder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder numero(int numero) {
            this.numero = numero;
            return this;
        }

        public Endereco build() {
            Endereco build = new Endereco(this);

            build.checkObject(build.getLogradouro(), build.getCidade(), build.getEstado(), build.getNumero());

            return build;
        }
    }

    private void checkObject(String cidade, String logradouro, String estado, int numero) {
        notNull(cidade, "Cidade não pode ser nulo");
        notEmpty(cidade, "Cidade não pode estar vazio");
        isTrue(cidade.length() <= MAX_LENGTH_CIDADE,
                "Cidade cannot be longer than %d characters",
                MAX_LENGTH_CIDADE
        );

        notNull(logradouro, "Logradouro não pode ser nulo");
        notEmpty(logradouro, "Logradouro não pode estar vazio");
        if (logradouro != null) {
            isTrue(logradouro.length() <= MAX_LENGTH_LOGRADOURO,
                    "Logradouro não pode ter mais que %d characters",
                    MAX_LENGTH_LOGRADOURO
            );
        }

        notNull(estado, "Estado não pode ser nulo");
        notEmpty(estado, "Estado não pode estar vazio");
        if (estado != null) {
            isTrue(estado.length() <= MAX_LENGTH_ESTADO,
                    "Estado não pode ter mais que %d characters",
                    MAX_LENGTH_ESTADO
            );
        }

        notNull(numero, "Numero não pode ser nulo");
    }
}
