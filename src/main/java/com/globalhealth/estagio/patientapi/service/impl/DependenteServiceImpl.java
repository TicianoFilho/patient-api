package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhealth.estagio.patientapi.dto.DependenteDto;
import com.globalhealth.estagio.patientapi.dto.EnderecoDto;
import com.globalhealth.estagio.patientapi.entity.DependenteEntity;
import com.globalhealth.estagio.patientapi.entity.EnderecoEntity;
import com.globalhealth.estagio.patientapi.exception.ResourceNotFoundException;
import com.globalhealth.estagio.patientapi.repository.DependenteRepository;
import com.globalhealth.estagio.patientapi.repository.EnderecoRepository;
import com.globalhealth.estagio.patientapi.service.DependenteService;
import com.globalhealth.estagio.patientapi.service.EnderecoService;

@Service
public class DependenteServiceImpl implements DependenteService {
	
	private DependenteRepository dependenteRepository;
	private EnderecoService enderecoService;
	
	public DependenteServiceImpl(DependenteRepository dependenteRepository, EnderecoService endereService) {
		this.dependenteRepository = dependenteRepository;
		this.enderecoService = endereService;
	}

	@Override
	@Transactional
	public DependenteDto create(DependenteDto dto) {
		
		DependenteEntity dependente = this.toEntity(dto);
		
		System.out.println("DependenteEntity => " + dependente);
		
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
		DependenteEntity entity = new DependenteEntity();	
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setCodigoCartao(dto.getCodigoCartao());
		entity.setEndereco(this.toEnderecoEntity(dto.getEndereco()));
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
	
	public EnderecoEntity toEnderecoEntity(EnderecoDto dto) {
		EnderecoEntity entity = new EnderecoEntity();
		//entity.setId(dto.getId());
		entity.setCep(dto.getCep());
		entity.setRua(dto.getRua());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setEstado(dto.getEstado());
		entity.setPais(dto.getPais());
		return entity;
	}

}
