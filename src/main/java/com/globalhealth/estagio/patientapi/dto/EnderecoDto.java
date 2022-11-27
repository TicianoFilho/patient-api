package com.globalhealth.estagio.patientapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EnderecoDto {

	private long id;
	
	@NotBlank(message = "O campo rua não pode ser vazio")
	private String rua;
	
	@NotBlank(message = "O campo bairro não pode ser vazio")
	private String bairro;
	
	@NotBlank(message = "O campo cidade não pode ser vazio")
	private String cidade;
	
	@NotBlank(message = "O campo estado não pode ser vazio")
	private String estado;
	
	@NotBlank(message = "O campo cep não pode ser vazio")
	private String cep;
	
	@NotBlank(message = "O campo país não pode ser vazio")
	private String pais;
}
