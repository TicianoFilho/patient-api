package com.globalhealth.estagio.patientapi.service;

import java.util.List;

import com.globalhealth.estagio.patientapi.dto.TitularDto;

public interface TitularService {

	public TitularDto create(TitularDto dto);
	public List<TitularDto> findAll();
	public TitularDto findOneById(long id);
	public TitularDto update(TitularDto dto, long id);
	public void delete(long id);
}
