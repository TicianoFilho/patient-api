package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhealth.estagio.patientapi.dto.DependenteDto;
import com.globalhealth.estagio.patientapi.entity.DependenteEntity;
import com.globalhealth.estagio.patientapi.exception.ResourceNotFoundException;
import com.globalhealth.estagio.patientapi.repository.DependenteRepository;
import com.globalhealth.estagio.patientapi.service.DependenteService;

@Service
public class DependenteServiceImpl implements DependenteService {
	
	private DependenteRepository dependenteRepository;
	private ModelMapper modelMapper;
	
	public DependenteServiceImpl(DependenteRepository dependenteRepository, ModelMapper modelMapper) {
		this.dependenteRepository = dependenteRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public DependenteDto create(DependenteDto dto) {		
		DependenteEntity dependente = this.toEntity(dto);	
		DependenteEntity newDependente = dependenteRepository.save(dependente);		
		return this.toDto(newDependente);
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
	
	@Override
	public DependenteDto update(DependenteDto dto, long id) {
		DependenteEntity entity = dependenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dependente", "id", id));
		
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setCodigoCartao(dto.getCodigoCartao());
		entity.setActive(dto.isActive());
		
		DependenteEntity updatedDependente = dependenteRepository.save(entity);
		return this.toDto(updatedDependente);
	}
	
	@Override
	public void delete(long id) {
		DependenteEntity entity = dependenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dependente", "id", id));
		dependenteRepository.delete(entity);
	}

	private DependenteEntity toEntity(DependenteDto dto) {
		DependenteEntity entity = modelMapper.map(dto, DependenteEntity.class);
		return entity;
	}
	
	private DependenteDto toDto(DependenteEntity entity) {
		DependenteDto dto = modelMapper.map(entity, DependenteDto.class);
		return dto;
	}

}
