package com.globalhealth.estagio.patientapi.auth.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.globalhealth.estagio.patientapi.auth.filter.JWTAutenticarFilter;
import com.globalhealth.estagio.patientapi.auth.filter.JWTValidarFilter;
import com.globalhealth.estagio.patientapi.auth.service.DetalheUsuarioServiceImpl;

@EnableWebSecurity
public class JWTConfig extends WebSecurityConfigurerAdapter {

	private final DetalheUsuarioServiceImpl usuarioService;
	private final PasswordEncoder passwordEncoder;
	
	public JWTConfig(DetalheUsuarioServiceImpl usuarioService, PasswordEncoder passwordEncoder) {
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login/**").permitAll()
			.antMatchers("/v3/api-docs/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilter(new JWTAutenticarFilter(authenticationManager()))
			.addFilter(new JWTValidarFilter(authenticationManager()))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	// to accept requests coming from others devices
//	@Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return source;
//    }
	
	
	
	
}
