package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.MembroRequestDto;
import com.example.demo.domain.models.dtos.MembroResponseDto;
import com.example.demo.domain.services.interfaces.MembroDomainService;

@Service
public class MembroDomainServiceImpl implements MembroDomainService {

	@Override
	public MembroResponseDto cadastrarMembro(MembroRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembroResponseDto atualizarMembro(UUID id, MembroRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembroResponseDto excluirMembro(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembroResponseDto consultarMembroPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembroResponseDto> consultarMembros() {
		// TODO Auto-generated method stub
		return null;
	}

}
