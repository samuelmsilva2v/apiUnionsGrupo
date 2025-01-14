package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.ReferenciaRequestDto;
import com.example.demo.domain.models.dtos.ReferenciaResponseDto;
import com.example.demo.domain.models.entities.Referencia;
import com.example.demo.domain.services.interfaces.ReferenciaDomainService;
import com.example.demo.infrastructure.repositories.MembroRepository;
import com.example.demo.infrastructure.repositories.ReferenciaRepository;

@Service
public class ReferenciaDomainServiceImpl implements ReferenciaDomainService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ReferenciaRepository referenciaRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Override
	public ReferenciaResponseDto publicarReferencia(ReferenciaRequestDto request) {

		var avaliador = membroRepository.findById(request.getIdAvaliador()).get();

		var avaliado = membroRepository.findById(request.getIdAvaliado()).get();

		var referencia = modelMapper.map(request, Referencia.class);
		referencia.setIdReferencia(UUID.randomUUID());
		referencia.setObservacoes(request.getObservacoes());
		referencia.setStatus(request.getStatus());
		referencia.setTipoReferencia(request.getTipoReferencia());
		referencia.setAvaliacao(request.getAvaliacao());
		referencia.setAvaliador(avaliador);
		referencia.setAvaliado(avaliado);
		
		referenciaRepository.save(referencia);
		
		return modelMapper.map(referencia, ReferenciaResponseDto.class);
	}

	@Override
	public ReferenciaResponseDto editarReferencia(UUID id, ReferenciaRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluirReferencia(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenciaResponseDto consultarReferenciaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReferenciaResponseDto> consultarReferencias() {
		// TODO Auto-generated method stub
		return null;
	}

}
