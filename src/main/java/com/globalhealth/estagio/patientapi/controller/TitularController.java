package com.globalhealth.estagio.patientapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhealth.estagio.patientapi.dto.TitularDto;
import com.globalhealth.estagio.patientapi.entity.TitularEntity;
import com.globalhealth.estagio.patientapi.response.Response;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<TitularDto> findOneById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(titularService.findOneById(id));
	}
	
	@PostMapping
	public ResponseEntity<Response<TitularDto>> create(@Valid @RequestBody TitularDto dto, BindingResult result) {
		Response<TitularDto> response = new Response<TitularDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(err -> response.getErrors().add(err.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		TitularDto newTitular = titularService.create(dto);
		response.setData(newTitular);
		
		return new ResponseEntity<Response<TitularDto>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<TitularDto>> update(@Valid @RequestBody TitularDto dto, BindingResult result,
			@PathVariable(name = "id") long id) {
		Response<TitularDto> response = new Response<TitularDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(err -> response.getErrors().add(err.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		TitularDto newTitular = titularService.update(dto,id);
		response.setData(newTitular);
		
		return new ResponseEntity<Response<TitularDto>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		titularService.delete(id);
		return new ResponseEntity<String>(String.format("Titular de id : %s excluído com sucesso.", id), HttpStatus.OK);
	}
	
}
