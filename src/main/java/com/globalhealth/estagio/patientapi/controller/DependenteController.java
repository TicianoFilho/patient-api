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
	public ResponseEntity<Response<DependenteDto>> createDependente(@Valid @RequestBody DependenteDto dto, 
			BindingResult result) {
		
		Response<DependenteDto> response = new Response<DependenteDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(dependenteService.create(dto));
		return new ResponseEntity<Response<DependenteDto>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<DependenteDto> findAll() {
		return dependenteService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DependenteDto> findOneById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(dependenteService.findOneById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<DependenteDto>> update(@RequestBody DependenteDto dto, BindingResult result,
			@PathVariable(name = "id") long id) {
		
		Response<DependenteDto> response = new Response<DependenteDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(dependenteService.update(dto, id));
		return new ResponseEntity<Response<DependenteDto>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id){
		dependenteService.delete(id);
		return new ResponseEntity<String>(String.format("Dependente de id %s excluído.", id), HttpStatus.OK);
	}
}
