package com.globalhealth.estagio.patientapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "titular")
public class TitularEntity extends Paciente {

	@OneToMany(mappedBy = "titular")
	private List<DependenteEntity> dependentes;
}
