package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.ReferenciaRequestDto;
import com.example.demo.domain.models.dtos.ReferenciaResponseDto;

public interface ReferenciaDomainService {

	ReferenciaResponseDto publicarReferencia(ReferenciaRequestDto request);
	
	ReferenciaResponseDto editarReferencia(UUID id, ReferenciaRequestDto request);
	
	String excluirReferencia(UUID id);
	
	ReferenciaResponseDto consultarReferenciaPorId(UUID id);
	
	List<ReferenciaResponseDto> consultarReferencias();
}
