package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.dto.EnderecoDto;
import com.globalhealth.estagio.patientapi.dto.TitularDto;
import com.globalhealth.estagio.patientapi.entity.TitularEntity;
import com.globalhealth.estagio.patientapi.entity.EnderecoEntity;
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
	public TitularDto create(TitularDto dto) {
		
		return null;
	}

	@Override
	public List<TitularDto> findAll() {
		List<TitularEntity> titulares = titularRepository.findAll();
		return titulares.stream().map(titular -> this.toDto(titular)).collect(Collectors.toList());
	}

	@Override
	public TitularDto findOneById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TitularDto update(TitularDto dto, long id) {
		// TODO Auto-generated method stub
		return null;
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
	
	public EnderecoEntity toEnderecoEntity(EnderecoDto dto) {
		EnderecoEntity entity = modelMapper.map(dto, EnderecoEntity.class);
		return entity;
	}
	public EnderecoDto toEnderecoDto(EnderecoEntity entity) {
		EnderecoDto dto = modelMapper.map(entity, EnderecoDto.class);
		return dto;
	}

}
