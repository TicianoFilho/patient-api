package com.globalhealth.estagio.patientapi.auth.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globalhealth.estagio.patientapi.auth.data.DetalheUsuarioData;
import com.globalhealth.estagio.patientapi.entity.UsuarioEntity;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {
	
	public static final int TOKEN_EXPIRACAO = 600_000;
	
	public static final String TOKEN_ASSINATURA = "b925e02b-5b12-4c90-9a9c-688db300ebd2";
	
	private final AuthenticationManager authenticationManager;

	public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			UsuarioEntity usuario = new ObjectMapper().readValue(request.getInputStream(), UsuarioEntity.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					usuario.getUsuario(), 
					usuario.getSenha(), 
					new ArrayList<>()
			));
			
		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar o usuário", e);
		}	
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
		
		System.out.println("vai assinar agora: " + TOKEN_ASSINATURA);
		String token = JWT.create()
				.withSubject(usuarioData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
				.sign(Algorithm.HMAC512(TOKEN_ASSINATURA));
		
		response.getWriter().write(token);
		response.getWriter().flush();
	}
	
	
	

}
