package com.globalhealth.estagio.patientapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhealth.estagio.patientapi.service.TitularService;

@RestController
@RequestMapping("/api/titulares")
public class TitularController {

	private TitularService titularService;

	public TitularController(TitularService titularService) {
		this.titularService = titularService;
	}
	

}
