package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.ConvidadoRequestDto;
import com.example.demo.domain.models.dtos.ConvidadoResponseDto;

public interface ConvidadoDomainService {

	ConvidadoResponseDto cadastrarConvidado(ConvidadoRequestDto request);
	
	ConvidadoResponseDto alterarConvidado(UUID id, ConvidadoRequestDto request);
	
	String excluirConvidado(UUID id);
	
	ConvidadoResponseDto consultarConvidadoPorId(UUID id);
	
	List<ConvidadoResponseDto> consultarConvidados();
}
