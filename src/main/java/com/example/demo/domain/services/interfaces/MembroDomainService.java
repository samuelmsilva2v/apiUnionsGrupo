package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.MembroRequestDto;
import com.example.demo.domain.models.dtos.MembroResponseDto;

public interface MembroDomainService {

	MembroResponseDto cadastrarMembro(MembroRequestDto request);
	
	MembroResponseDto atualizarMembro(UUID id, MembroRequestDto request);
	
	String excluirMembro(UUID id);
	
	MembroResponseDto consultarMembroPorId(UUID id);
	
	List<MembroResponseDto> consultarMembros();

}
