package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.GrupoRequestDto;
import com.example.demo.domain.models.dtos.GrupoResponseDto;
import com.example.demo.domain.models.entities.Grupo;
import com.example.demo.domain.services.interfaces.GrupoDomainService;
import com.example.demo.infrastructure.repositories.GrupoRepository;

@Service
public class GrupoDomainServiceImpl implements GrupoDomainService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private GrupoRepository grupoRepository;

	@Override
	public GrupoResponseDto cadastrarGrupo(GrupoRequestDto request) {

		var grupo = modelMapper.map(request, Grupo.class);
		grupo.setIdGrupo(UUID.randomUUID());

		grupoRepository.save(grupo);

		return modelMapper.map(grupo, GrupoResponseDto.class);
	}

	@Override
	public GrupoResponseDto alterarGrupo(UUID id, GrupoRequestDto request) {

		var grupo = grupoRepository.findById(id).get();

		grupo.setNome(request.getNome());

		grupoRepository.save(grupo);

		return modelMapper.map(grupo, GrupoResponseDto.class);
	}

	@Override
	public String excluirGrupo(UUID id) {

		var grupo = grupoRepository.findById(id).get();

		grupoRepository.delete(grupo);

		return "O grupo foi excluído com sucesso!";
	}

	@Override
	public GrupoResponseDto consultarGrupoPorId(UUID id) {

		var grupo = grupoRepository.findById(id).get();

		return modelMapper.map(grupo, GrupoResponseDto.class);
	}

	@Override
	public List<GrupoResponseDto> consultarGrupos() {
		
		return grupoRepository.findAll().stream().map(grupo -> modelMapper.map(grupo, GrupoResponseDto.class))
				.collect(Collectors.toList());
	}

}