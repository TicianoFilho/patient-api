package com.globalhealth.estagio.patientapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatientApiApplication {

	@Bean
	public ModelMapper modelMapper() {                  // convert entity to dto and vice-versa
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PatientApiApplication.class, args);
	}

}
