package com.globalhealth.estagio.patientapi.service;

import java.util.List;

import com.globalhealth.estagio.patientapi.dto.UsuarioDto;

public interface UsuarioService {
	
	public UsuarioDto findByUsuario(String login);
	public List<UsuarioDto> findAll();
}
