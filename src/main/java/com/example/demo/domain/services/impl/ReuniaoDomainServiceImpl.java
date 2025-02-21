package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.ReuniaoRequestDto;
import com.example.demo.domain.models.dtos.ReuniaoResponseDto;
import com.example.demo.domain.models.entities.Reuniao;
import com.example.demo.domain.services.interfaces.ReuniaoDomainService;
import com.example.demo.infrastructure.repositories.MembroRepository;
import com.example.demo.infrastructure.repositories.ReuniaoRepository;

@Service
public class ReuniaoDomainServiceImpl implements ReuniaoDomainService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ReuniaoRepository reuniaoRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Override
	public ReuniaoResponseDto marcarReuniao(ReuniaoRequestDto request) {

		var solicitante = membroRepository.findById(request.getIdSolicitante()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdSolicitante() + " não encontrado."));

		var convidado = membroRepository.findById(request.getIdConvidado()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdConvidado() + " não encontrado."));

		var reuniao = new Reuniao();
		reuniao.setId(UUID.randomUUID());
		reuniao.setDataEHora(request.getDataEHora());
		reuniao.setLocal(request.getLocal());
		reuniao.setMotivo(request.getMotivo());
		reuniao.setSolicitante(solicitante);
		reuniao.setConvidado(convidado);

		reuniaoRepository.save(reuniao);

		return modelMapper.map(reuniao, ReuniaoResponseDto.class);
	}

	@Override
	public ReuniaoResponseDto alterarReuniao(UUID id, ReuniaoRequestDto request) {

		var reuniao = reuniaoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("A reunião " + id + " não foi encontrada."));

		var solicitante = membroRepository.findById(request.getIdSolicitante()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdSolicitante() + " não encontrado."));

		var convidado = membroRepository.findById(request.getIdConvidado()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdConvidado() + " não encontrado."));

		reuniao.setDataEHora(request.getDataEHora());
		reuniao.setLocal(request.getLocal());
		reuniao.setMotivo(request.getMotivo());
		reuniao.setSolicitante(solicitante);
		reuniao.setConvidado(convidado);

		reuniaoRepository.save(reuniao);

		return modelMapper.map(reuniao, ReuniaoResponseDto.class);
	}

	@Override
	public String desmarcarReuniao(UUID id) {

		var reuniao = reuniaoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("A reunião " + id + " não foi encontrada."));

		reuniaoRepository.delete(reuniao);

		return "A reunião foi desmarcada com sucesso!";
	}

	@Override
	public ReuniaoResponseDto consultarReuniaoPorId(UUID id) {

		var reuniao = reuniaoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("A reunião " + id + " não foi encontrada."));

		return modelMapper.map(reuniao, ReuniaoResponseDto.class);
	}

	@Override
	public List<ReuniaoResponseDto> consultarReunioes() {

		return reuniaoRepository.findAll().stream().map(reuniao -> modelMapper.map(reuniao, ReuniaoResponseDto.class))
				.collect(Collectors.toList());
	}

}
