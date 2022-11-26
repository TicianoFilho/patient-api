package com.globalhealth.estagio.patientapi.dto;

import com.globalhealth.estagio.patientapi.model.entity.DependenteEntity;

public class DependenteDto extends Paciente {

	public static DependenteEntity toEntity(DependenteDto dto) {
		DependenteEntity entity = new DependenteEntity();	
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setCodigoCartao(dto.getCodigoCartao());
		return entity;
	}
	
	public static DependenteDto toDto(DependenteEntity entity) {
		DependenteDto dto = new DependenteDto();
		dto.setNome(entity.getNome());
		dto.setCpf(entity.getCpf());
		dto.setCodigoCartao(entity.getCodigoCartao());
		return dto;
	}
}
