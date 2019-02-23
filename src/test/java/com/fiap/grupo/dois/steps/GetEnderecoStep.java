package com.fiap.grupo.dois.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fiap.grupo.dois.cucumber.CucumberRoot;
import com.fiap.grupo.dois.model.Endereco;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetEnderecoStep extends CucumberRoot{
	
	private ResponseEntity<String> response;
	@SuppressWarnings("unused")
	private List<Endereco> responseObject;
	
	@SuppressWarnings("unchecked")
	@When("^O endereco chama a api /endereco$")
	public void o_endereco_chama_a_api_endereco() throws Throwable {
		Endereco aluno = new Endereco();
		aluno.update("Barueri", "Estrada do Alto", "SP", 123);
		
		template.postForObject("/api/endereco", aluno, Endereco.class);
		response = template.getForEntity("/api/endereco", String.class);
		responseObject = template.getForObject("/api/endereco", List.class);
	}

	@Then("^Valido o codigo de retorno (\\d+)$")
	public void valido_o_codigo_de_retorno(int statusCode) throws Throwable {
		HttpStatus currentStatusCode = response.getStatusCode();
        assertThat("status code is incorrect : " +
                response.getBody(), currentStatusCode.value(), is(statusCode));
	}
}
