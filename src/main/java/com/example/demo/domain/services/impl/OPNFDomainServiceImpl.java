package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.OPNFRequestDto;
import com.example.demo.domain.models.dtos.OPNFResponseDto;
import com.example.demo.domain.services.interfaces.OPNFDomainService;

@Service
public class OPNFDomainServiceImpl implements OPNFDomainService {

	@Override
	public OPNFResponseDto criarOPNF(OPNFRequestDto response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OPNFResponseDto alterarOPNF(UUID id, OPNFRequestDto response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluirOPNF(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OPNFResponseDto consultarOPNFPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OPNFResponseDto> consultarOPNFs() {
		// TODO Auto-generated method stub
		return null;
	}

}
