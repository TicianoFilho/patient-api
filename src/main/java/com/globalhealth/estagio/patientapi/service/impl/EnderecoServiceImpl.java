package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.dto.EnderecoDto;
import com.globalhealth.estagio.patientapi.entity.EnderecoEntity;
import com.globalhealth.estagio.patientapi.repository.EnderecoRepository;
import com.globalhealth.estagio.patientapi.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	private EnderecoRepository enderecoRepository;
	private ModelMapper modelMapper;
	
	public EnderecoServiceImpl(EnderecoRepository enderecoRepository, ModelMapper modelMapper) {
		this.enderecoRepository = enderecoRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<EnderecoDto> findAll() {
		List<EnderecoEntity> enderecos = enderecoRepository.findAll();
		return enderecos.stream().map(endereco -> this.toDto(endereco)).collect(Collectors.toList());
	}
	
	private EnderecoDto toDto(EnderecoEntity entity) {
		EnderecoDto dto = modelMapper.map(entity, EnderecoDto.class);
		return dto;
	}
	
	public EnderecoEntity toEntity(EnderecoDto dto) {
		EnderecoEntity entity = modelMapper.map(dto, EnderecoEntity.class);
		return entity;
	}
}
