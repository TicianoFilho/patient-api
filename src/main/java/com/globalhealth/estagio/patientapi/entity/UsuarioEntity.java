package com.globalhealth.estagio.patientapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity extends AppBaseEntityClass {

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String usuario;
	
	@Column(nullable = false)
	private String senha;
}
