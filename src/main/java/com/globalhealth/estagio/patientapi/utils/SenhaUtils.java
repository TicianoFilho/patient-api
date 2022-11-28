package com.globalhealth.estagio.patientapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

	// Generates the password hash
	public static String gerarBcrypt(String senha) {
		if (senha == null) {
			return senha;
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}
	
	// validates given password
	public static boolean senhaValida(String senha, String hash) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senha, hash);
	}	
	
}
