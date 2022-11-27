package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.dto.EnderecoDto;
import com.globalhealth.estagio.patientapi.entity.EnderecoEntity;
import com.globalhealth.estagio.patientapi.repository.EnderecoRepository;
import com.globalhealth.estagio.patientapi.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	private EnderecoRepository enderecoRepository;
	
	public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	public List<EnderecoDto> findAll() {
		List<EnderecoEntity> enderecos = enderecoRepository.findAll();
		return enderecos.stream().map(endereco -> this.toDto(endereco)).collect(Collectors.toList());
	}
	
	@Override
	public EnderecoDto create(EnderecoDto dto) {
		EnderecoEntity entity = this.toEntity(dto);
		EnderecoEntity newEndereco = enderecoRepository.save(entity);
		return this.toDto(newEndereco);
	}
	
	private EnderecoDto toDto(EnderecoEntity entity) {
		EnderecoDto dto = new EnderecoDto();
		dto.setId(entity.getId());
		dto.setCep(entity.getCep());
		dto.setRua(entity.getRua());
		dto.setBairro(entity.getBairro());
		dto.setCidade(entity.getCidade());
		dto.setEstado(entity.getEstado());
		dto.setPais(entity.getPais());
		return dto;
	}
	
	public EnderecoEntity toEntity(EnderecoDto dto) {
		EnderecoEntity entity = new EnderecoEntity();
		entity.setCep(dto.getCep());
		entity.setRua(dto.getRua());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setEstado(dto.getEstado());
		entity.setPais(dto.getPais());
		return entity;
	}
}
