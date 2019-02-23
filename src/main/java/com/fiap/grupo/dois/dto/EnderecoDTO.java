package com.fiap.grupo.dois.dto;

import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import com.fiap.grupo.dois.model.Endereco;

import java.lang.invoke.MethodType;

@SuppressWarnings("deprecation")
public class EnderecoDTO {

	private String id;

	@NotEmpty
    @Size(max = Endereco.MAX_LENGTH_LOGRADOURO)
    private String logradouro;

    @NotEmpty
    @Size(max = Endereco.MAX_LENGTH_CIDADE)
    private String cidade;
    
    @NotEmpty
    @Size(max = Endereco.MAX_LENGTH_ESTADO)
    private String estado;

	@NotNull
    private int numero;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	@Override
	public String toString() {
		return "EnderecoDTO{" +
				"id='" + id + '\'' +
				", logradouro='" + logradouro + '\'' +
				", cidade='" + cidade + '\'' +
				", estado='" + estado + '\'' +
				", numero=" + numero +
				'}';
	}
}
