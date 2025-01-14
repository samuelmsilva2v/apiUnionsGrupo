package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.ReuniaoRequestDto;
import com.example.demo.domain.models.dtos.ReuniaoResponseDto;

public interface ReuniaoDomainService {

	ReuniaoResponseDto marcarReuniao(ReuniaoRequestDto request);
	
	ReuniaoResponseDto alterarReuniao(UUID id, ReuniaoRequestDto request);
	
	String desmarcarReuniao(UUID id);
	
	ReuniaoResponseDto consultarReuniaoPorId(UUID id);
	
	List<ReuniaoResponseDto> consultarReunioes();
}
