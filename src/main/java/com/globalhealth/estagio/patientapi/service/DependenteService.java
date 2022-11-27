package com.globalhealth.estagio.patientapi.service;

import java.util.List;

import com.globalhealth.estagio.patientapi.dto.DependenteDto;

public interface DependenteService {

	public DependenteDto create(DependenteDto dto);
	public List<DependenteDto> findAll();
	public DependenteDto findOneById(long id);
	public DependenteDto update(DependenteDto dto, long id);
	public void delete(long id);
}
