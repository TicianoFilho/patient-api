package com.globalhealth.estagio.patientapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhealth.estagio.patientapi.dto.TitularDto;
import com.globalhealth.estagio.patientapi.service.TitularService;

@RestController
@RequestMapping("/api/titulares")
public class TitularController {

	private TitularService titularService;

	public TitularController(TitularService titularService) {
		this.titularService = titularService;
	}
	
	@GetMapping
	public List<TitularDto> findAll() {
		return titularService.findAll();
	}
}
