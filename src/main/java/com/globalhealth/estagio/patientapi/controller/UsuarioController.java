package com.globalhealth.estagio.patientapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhealth.estagio.patientapi.dto.UsuarioDto;
import com.globalhealth.estagio.patientapi.response.Response;
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
	
	@PostMapping
	public ResponseEntity<Response<UsuarioDto>> createUsuario(@Valid @RequestBody UsuarioDto usuario, BindingResult result) {
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(usuarioService.create(usuario));
		return new ResponseEntity<Response<UsuarioDto>>(response, HttpStatus.CREATED); 
		
	}
}
