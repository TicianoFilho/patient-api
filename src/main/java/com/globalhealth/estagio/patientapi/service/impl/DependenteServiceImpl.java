package com.globalhealth.estagio.patientapi.service.impl;

import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.dto.DependenteDto;
import com.globalhealth.estagio.patientapi.model.entity.DependenteEntity;
import com.globalhealth.estagio.patientapi.model.repository.DependenteRepository;
import com.globalhealth.estagio.patientapi.service.DependenteService;

@Service
public class DependenteServiceImpl implements DependenteService {

	private DependenteRepository dependenteRepository;
	
	public DependenteServiceImpl(DependenteRepository dependenteRepository) {
		this.dependenteRepository = dependenteRepository;
	}

	@Override
	public DependenteDto create(DependenteDto dto) {
		DependenteEntity dependente = DependenteDto.toEntity(dto);
		DependenteEntity newDependente = dependenteRepository.save(dependente);
		DependenteDto dependenteDto = DependenteDto.toDto(newDependente);
		return dependenteDto;
	}

}
