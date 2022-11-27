package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.dto.DependenteDto;
import com.globalhealth.estagio.patientapi.entity.DependenteEntity;
import com.globalhealth.estagio.patientapi.exception.ResourceNotFoundException;
import com.globalhealth.estagio.patientapi.repository.DependenteRepository;
import com.globalhealth.estagio.patientapi.service.DependenteService;

@Service
public class DependenteServiceImpl implements DependenteService {

	private DependenteRepository dependenteRepository;
	
	public DependenteServiceImpl(DependenteRepository dependenteRepository) {
		this.dependenteRepository = dependenteRepository;
	}

	@Override
	public DependenteDto create(DependenteDto dto) {
		DependenteEntity dependente = this.toEntity(dto);
		DependenteEntity newDependente = dependenteRepository.save(dependente);
		DependenteDto dependenteDto = this.toDto(newDependente);
		return dependenteDto;
	}
	
	@Override
	public List<DependenteDto> findAll() {
		List<DependenteEntity> dependentes = dependenteRepository.findAll();
		return dependentes.stream().map(depentende -> this.toDto(depentende)).collect(Collectors.toList());
	}
	
	@Override
	public DependenteDto findOneById(long id) {
		DependenteEntity entity = dependenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dependente", "id", id));
		return this.toDto(entity);
	}

	private DependenteEntity toEntity(DependenteDto dto) {
		DependenteEntity entity = new DependenteEntity();	
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setCodigoCartao(dto.getCodigoCartao());
		return entity;
	}
	
	private DependenteDto toDto(DependenteEntity entity) {
		DependenteDto dto = new DependenteDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setCpf(entity.getCpf());
		dto.setCodigoCartao(entity.getCodigoCartao());
		return dto;
	}

}
