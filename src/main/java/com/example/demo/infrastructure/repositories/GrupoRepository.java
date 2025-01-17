package com.example.demo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.models.entities.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, UUID> {

	boolean existsByNome(String nome);
	
	boolean existsByNomeAndIdNot(String nome, UUID id);
}
