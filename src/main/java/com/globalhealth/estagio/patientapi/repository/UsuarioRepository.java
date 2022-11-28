package com.globalhealth.estagio.patientapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalhealth.estagio.patientapi.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	public Optional<UsuarioEntity> findByUsuario(String login);
}
