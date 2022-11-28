package com.globalhealth.estagio.patientapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

	private long id;
	
	@NotBlank(message = "O campo nome não pode ser vazio")
	private String nome;
	
	@NotBlank(message = "O campo usuário não pode ser vazio")
	private String usuario;
	
	@NotBlank(message = "O campo senha não pode ser vazio")
	private String senha;
}
