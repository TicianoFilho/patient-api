package com.globalhealth.estagio.patientapi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "dependente")
public class DependenteEntity extends Paciente {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "titular_id")
	private TitularEntity titular;
}
