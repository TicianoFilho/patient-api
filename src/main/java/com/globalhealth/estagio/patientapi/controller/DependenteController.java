package com.globalhealth.estagio.patientapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhealth.estagio.patientapi.dto.DependenteDto;
import com.globalhealth.estagio.patientapi.response.Response;
import com.globalhealth.estagio.patientapi.service.DependenteService;

@RestController
@RequestMapping("/api/dependentes")
public class DependenteController {

	private DependenteService dependenteService;

	public DependenteController(DependenteService dependenteService) {
		this.dependenteService = dependenteService;
	}
	
	@PostMapping
	public ResponseEntity<Response<DependenteDto>> createDependente(@RequestBody DependenteDto dto) {
		Response<DependenteDto> response = new Response<DependenteDto>();
		response.setData(dependenteService.create(dto));
		return ResponseEntity.ok(response);
	}
}
