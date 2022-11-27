package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.dto.DependenteDto;
import com.globalhealth.estagio.patientapi.dto.EnderecoDto;
import com.globalhealth.estagio.patientapi.dto.TitularDto;
import com.globalhealth.estagio.patientapi.entity.TitularEntity;
import com.globalhealth.estagio.patientapi.entity.DependenteEntity;
import com.globalhealth.estagio.patientapi.entity.EnderecoEntity;
import com.globalhealth.estagio.patientapi.repository.TitularRepository;
import com.globalhealth.estagio.patientapi.service.TitularService;

@Service
public class TitularServiceImpl implements TitularService {

	private TitularRepository titularRepository;
	
	public TitularServiceImpl(TitularRepository titularRepository) {
		this.titularRepository = titularRepository;
	}

	@Override
	public TitularDto create(TitularDto dto) {
		
		return null;
	}

	@Override
	public List<TitularDto> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		TitularEntity entity = new TitularEntity();	
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setCodigoCartao(dto.getCodigoCartao());
		entity.setEndereco(this.toEnderecoEntity(dto.getEndereco()));
		entity.setDependentes(this.toDependenteEntity(dto.getDependentes()));
		return entity;
	}
	
	private List<DependenteEntity> toDependenteEntity(List<DependenteDto> dependentes) {

		return null;
	}

	private TitularDto toDto(TitularEntity entity) {
		TitularDto dto = new TitularDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setCpf(entity.getCpf());
		dto.setCodigoCartao(entity.getCodigoCartao());
		dto.setEndereco(this.toEnderecoDto(entity.getEndereco()));
		return dto;
	}
	
	public EnderecoEntity toEnderecoEntity(EnderecoDto dto) {
		EnderecoEntity entity = new EnderecoEntity();
		entity.setCep(dto.getCep());
		entity.setRua(dto.getRua());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setEstado(dto.getEstado());
		entity.setPais(dto.getPais());
		return entity;
	}
	public EnderecoDto toEnderecoDto(EnderecoEntity entity) {
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

}
