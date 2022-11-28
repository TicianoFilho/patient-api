package com.globalhealth.estagio.patientapi.dto;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {

	@NotBlank(message = "O campo nome não pode ser vazio")
	private String nome;
	
	@NotBlank(message = "O campo usuário não pode ser vazio")
	private String usuario;
	
	@NotBlank(message = "O campo senha não pode ser vazio")
	private String senha;
}
