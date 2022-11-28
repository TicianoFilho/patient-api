package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhealth.estagio.patientapi.dto.UsuarioDto;
import com.globalhealth.estagio.patientapi.entity.UsuarioEntity;
import com.globalhealth.estagio.patientapi.exception.ResourceNotFoundException;
import com.globalhealth.estagio.patientapi.repository.UsuarioRepository;
import com.globalhealth.estagio.patientapi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;
	private ModelMapper modelMapper;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
		this.usuarioRepository = usuarioRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public List<UsuarioDto> findAll() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(usuario -> this.toDto(usuario)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDto findByUsuario(String login) {
		UsuarioEntity entity = usuarioRepository.findByUsuario(login).orElseThrow(() -> new ResourceNotFoundException("Usuário", "login"));
		return this.toDto(entity); 
	}
	
	@Override
	@Transactional
	public UsuarioDto create(UsuarioDto usuario) {
		UsuarioEntity entity = this.toEntity(usuario);
		return this.toDto(usuarioRepository.save(entity));
	}
	
	private UsuarioEntity toEntity(UsuarioDto dto) {
		UsuarioEntity entity = modelMapper.map(dto, UsuarioEntity.class);
		return entity;
	}
	
	private UsuarioDto toDto(UsuarioEntity entity) {
		UsuarioDto dto = modelMapper.map(entity, UsuarioDto.class);
		return dto;
	}

}
