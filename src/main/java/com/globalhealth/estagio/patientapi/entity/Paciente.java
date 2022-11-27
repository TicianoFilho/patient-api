package com.globalhealth.estagio.patientapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Paciente extends AppBaseEntityClass {

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false, unique = true)
	private String codigoCartao;
	
	@Column(nullable = false)
	private boolean active = false;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private EnderecoEntity endereco;
}
