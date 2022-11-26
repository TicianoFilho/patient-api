package com.globalhealth.estagio.patientapi.dto;

import lombok.Data;

@Data
public abstract class Paciente {

	private Long id;
	private String nome;
	private String cpf;
	private String codigoCartao;
	private boolean active;
	
}
