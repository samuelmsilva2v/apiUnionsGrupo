package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.ConvidadoRequestDto;
import com.example.demo.domain.models.dtos.ConvidadoResponseDto;
import com.example.demo.domain.models.entities.Convidado;
import com.example.demo.domain.services.interfaces.ConvidadoDomainService;
import com.example.demo.infrastructure.repositories.ConvidadoRepository;
import com.example.demo.infrastructure.repositories.MembroRepository;

@Service
public class ConvidadoDomainServiceImpl implements ConvidadoDomainService {

	@Autowired
	private ConvidadoRepository convidadoRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ConvidadoResponseDto cadastrarConvidado(ConvidadoRequestDto request) {

		var membro = membroRepository.findById(request.getIdMembro()).get();

		var convidado = modelMapper.map(request, Convidado.class);
		convidado.setIdConvidado(UUID.randomUUID());
		convidado.setMembro(membro);

		convidadoRepository.save(convidado);

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public ConvidadoResponseDto alterarConvidado(UUID id, ConvidadoRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluirConvidado(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConvidadoResponseDto consultarConvidadoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConvidadoResponseDto> consultarConvidados() {
		// TODO Auto-generated method stub
		return null;
	}

}
