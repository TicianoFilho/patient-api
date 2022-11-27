package com.globalhealth.estagio.patientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalhealth.estagio.patientapi.entity.DependenteEntity;

@Repository
public interface DependenteRepository extends JpaRepository<DependenteEntity, Long>{

}
