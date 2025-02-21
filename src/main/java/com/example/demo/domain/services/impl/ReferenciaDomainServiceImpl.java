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

		var avaliador = membroRepository.findById(request.getIdAvaliador()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdAvaliador() + " não encontrado."));

		var avaliado = membroRepository.findById(request.getIdAvaliado()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdAvaliado() + " não encontrado."));

		var referencia = new Referencia();
		referencia.setId(UUID.randomUUID());
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

		var referencia = referenciaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("A referência " + id + " não foi encontrada."));

		var avaliador = membroRepository.findById(request.getIdAvaliador()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdAvaliador() + "não encontrado."));

		var avaliado = membroRepository.findById(request.getIdAvaliado()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdAvaliado() + " não encontrado."));

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

		var referencia = referenciaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("A referência " + id + " não foi encontrada."));

		referenciaRepository.delete(referencia);

		return "Referência excluída com sucesso!";
	}

	@Override
	public ReferenciaResponseDto consultarReferenciaPorId(UUID id) {

		var referencia = referenciaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("A referência " + id + " não foi encontrada."));

		return modelMapper.map(referencia, ReferenciaResponseDto.class);
	}

	@Override
	public List<ReferenciaResponseDto> consultarReferencias() {

		return referenciaRepository.findAll().stream()
				.map(referencia -> modelMapper.map(referencia, ReferenciaResponseDto.class))
				.collect(Collectors.toList());
	}
}
