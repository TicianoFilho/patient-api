package com.globalhealth.estagio.patientapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "titular")
public class TitularEntity extends Paciente {

	@OneToMany(mappedBy = "titular")
	private List<DependenteEntity> dependentes;
}
