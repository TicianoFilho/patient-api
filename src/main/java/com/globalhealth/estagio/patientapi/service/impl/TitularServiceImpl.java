package com.globalhealth.estagio.patientapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.dto.TitularDto;
import com.globalhealth.estagio.patientapi.repository.TitularRepository;
import com.globalhealth.estagio.patientapi.service.TitularService;

@Service
public class TitularServiceImpl implements TitularService {

	private TitularRepository titularRepository;
	
	public TitularServiceImpl(TitularRepository titularRepository) {
		this.titularRepository = titularRepository;
	}

	@Override
	public TitularDto create(TitularDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TitularDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TitularDto findOneById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TitularDto update(TitularDto dto, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
