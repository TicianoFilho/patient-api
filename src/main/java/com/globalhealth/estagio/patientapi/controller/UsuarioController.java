package com.globalhealth.estagio.patientapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhealth.estagio.patientapi.dto.UsuarioDto;
import com.globalhealth.estagio.patientapi.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll() {
		List<UsuarioDto> usuarios = usuarioService.findAll();
		return new ResponseEntity<List<UsuarioDto>>(usuarios, HttpStatus.OK);
	}
}
