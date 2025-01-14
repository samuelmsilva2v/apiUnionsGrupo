package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

		var referencia = new Referencia();
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
		
		var referencia = referenciaRepository.findById(id).get();
		
		var avaliador = membroRepository.findById(request.getIdAvaliador()).get();

		var avaliado = membroRepository.findById(request.getIdAvaliado()).get();
		
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
	public String excluirReferencia(UUID id) {
		
		var referencia = referenciaRepository.findById(id).get();
		
		referenciaRepository.delete(referencia);
		
		return "Referência excluída com sucesso!";
	}

	@Override
	public ReferenciaResponseDto consultarReferenciaPorId(UUID id) {
		
		var referencia = referenciaRepository.findById(id).get();
		
		return modelMapper.map(referencia, ReferenciaResponseDto.class);
	}

	@Override
	public List<ReferenciaResponseDto> consultarReferencias() {
		return referenciaRepository.findAll().stream()
				.map(referencia -> modelMapper.map(referencia, ReferenciaResponseDto.class)).collect(Collectors.toList());
	}
}
