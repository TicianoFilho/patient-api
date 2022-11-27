package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhealth.estagio.patientapi.dto.TitularDto;
import com.globalhealth.estagio.patientapi.entity.TitularEntity;
import com.globalhealth.estagio.patientapi.exception.ResourceNotFoundException;
import com.globalhealth.estagio.patientapi.repository.TitularRepository;
import com.globalhealth.estagio.patientapi.service.TitularService;

@Service
public class TitularServiceImpl implements TitularService {

	private TitularRepository titularRepository;
	private ModelMapper modelMapper;
	
	public TitularServiceImpl(TitularRepository titularRepository, ModelMapper modelMapper) {
		this.titularRepository = titularRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public TitularDto create(TitularDto dto) {
		TitularEntity entity = this.toEntity(dto);
		TitularEntity newTitular = titularRepository.save(entity);
		return this.toDto(newTitular);
	}

	@Override
	public List<TitularDto> findAll() {
		List<TitularEntity> titulares = titularRepository.findAll();
		return titulares.stream().map(titular -> this.toDto(titular)).collect(Collectors.toList());
	}

	@Override
	public TitularDto findOneById(long id) {
		TitularEntity titular = titularRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id", "id", id));
		return this.toDto(titular);
	}

	@Override
	public TitularDto update(TitularDto dto, long id) {
		TitularEntity titular = titularRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id", "id", id));		
		dto.setId(titular.getId());
		titular = this.toEntity(dto);
		return this.toDto(titularRepository.save(titular));
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	private TitularEntity toEntity(TitularDto dto) {
		TitularEntity entity = modelMapper.map(dto, TitularEntity.class);
		return entity;
	}

	private TitularDto toDto(TitularEntity entity) {
		TitularDto dto = modelMapper.map(entity, TitularDto.class);
		return dto;
	}
	
}
