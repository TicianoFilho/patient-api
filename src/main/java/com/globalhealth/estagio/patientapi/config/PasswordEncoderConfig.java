package com.globalhealth.estagio.patientapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

	@Bean
	public PasswordEncoder getPasswordEncoder() {                // for user password
		return new BCryptPasswordEncoder();
	}
}
