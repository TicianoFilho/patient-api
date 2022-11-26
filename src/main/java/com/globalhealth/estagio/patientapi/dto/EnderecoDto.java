package com.globalhealth.estagio.patientapi.dto;

import lombok.Data;

@Data
public class EnderecoDto {

	private String rua;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
	private String pais;
}
