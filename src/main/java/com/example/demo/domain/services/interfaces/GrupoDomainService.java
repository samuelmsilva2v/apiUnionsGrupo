package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.GrupoRequestDto;
import com.example.demo.domain.models.dtos.GrupoResponseDto;

public interface GrupoDomainService {

	GrupoResponseDto cadastrarGrupo(GrupoRequestDto request);
	
	GrupoResponseDto alterarGrupo(UUID id, GrupoRequestDto request);
	
	String excluirGrupo(UUID idGrupo);
	
	GrupoResponseDto consultarGrupoPorId(UUID id);
	
	List<GrupoResponseDto> consultarGrupos();
}