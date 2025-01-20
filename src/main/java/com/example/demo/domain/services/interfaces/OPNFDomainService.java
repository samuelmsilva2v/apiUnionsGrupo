package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.OPNFRequestDto;
import com.example.demo.domain.models.dtos.OPNFResponseDto;

public interface OPNFDomainService {

	OPNFResponseDto criarOPNF(OPNFRequestDto response);
	
	OPNFResponseDto alterarOPNF(UUID id, OPNFRequestDto response);
	
	String excluirOPNF(UUID id);
	
	OPNFResponseDto consultarOPNFPorId(UUID id);
	
	List<OPNFResponseDto> consultarOPNFs();
}
