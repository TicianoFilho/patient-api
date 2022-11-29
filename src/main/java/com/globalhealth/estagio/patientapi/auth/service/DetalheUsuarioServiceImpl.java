package com.globalhealth.estagio.patientapi.auth.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.globalhealth.estagio.patientapi.auth.data.DetalheUsuarioData;
import com.globalhealth.estagio.patientapi.entity.UsuarioEntity;
import com.globalhealth.estagio.patientapi.repository.UsuarioRepository;

@Service
public class DetalheUsuarioServiceImpl implements UserDetailsService {

	public final UsuarioRepository usuarioRepository;
	
	public DetalheUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioEntity> usuario = usuarioRepository.findByUsuario(username);
		
		if (!usuario.isPresent()) {
			throw new UsernameNotFoundException(String.format("Usuário %s não encontrado!", username));
		}
		
		return new DetalheUsuarioData(usuario);
	}

}
