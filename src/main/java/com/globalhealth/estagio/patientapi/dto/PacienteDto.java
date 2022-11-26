package com.globalhealth.estagio.patientapi.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public abstract class PacienteDto {

	private long id;
	
	@NotBlank(message = "O nome não pode ser vazio.")
	@Length(min = 5, max = 200, message = "O nome deve conter entre 5 a 200 caracteres.")
	private String nome;
	
	@NotBlank(message = "O CPF não pode ser vazio.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	@NotBlank(message = "O código do cartão não pode ser vazio.")
	private String codigoCartao;
	
	private boolean active;
	
}
