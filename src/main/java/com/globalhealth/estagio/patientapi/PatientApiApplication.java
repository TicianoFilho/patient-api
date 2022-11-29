package com.globalhealth.estagio.patientapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)                    // to disable Spring security ask login/password automatically.
public class PatientApiApplication {

	@Bean
	public ModelMapper modelMapper() {                  // convert entity to dto and vice-versa
		return new ModelMapper();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {                // for user password
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PatientApiApplication.class, args);
	}

}
