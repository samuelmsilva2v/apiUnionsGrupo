package com.example.demo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.models.entities.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, UUID> {

	boolean existsByEmail(String email);

    boolean existsByTelefone(String telefone);
    
    boolean existsByEmailAndIdNot(String email, UUID id);
    
    boolean existsByTelefoneAndIdNot(String telefone, UUID id);
}
