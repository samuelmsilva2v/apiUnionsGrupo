package com.example.demo.domain.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.MembroRequestDto;
import com.example.demo.domain.models.dtos.MembroResponseDto;
import com.example.demo.domain.models.entities.Grupo;
import com.example.demo.domain.models.entities.Membro;
import com.example.demo.domain.services.interfaces.MembroDomainService;
import com.example.demo.infrastructure.repositories.GrupoRepository;
import com.example.demo.infrastructure.repositories.MembroRepository;

@Service
public class MembroDomainServiceImpl implements MembroDomainService {

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MembroResponseDto cadastrarMembro(MembroRequestDto request) {

		List<Grupo> grupos = grupoRepository.findAllById(request.getGruposIds());

		if (grupos.size() != request.getGruposIds().size()) {
			throw new IllegalArgumentException("Um ou mais grupos informados não existem.");
		}

		if (membroRepository.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("O e-mail informado já está em uso.");
		}

		if (membroRepository.existsByTelefone(request.getTelefone())) {
			throw new IllegalArgumentException("O telefone informado já está em uso.");
		}

		var membro = modelMapper.map(request, Membro.class);
		membro.setId(UUID.randomUUID());

		membro.setGrupos(grupos);

		membroRepository.save(membro);

		return modelMapper.map(membro, MembroResponseDto.class);
	}

	@Override
	public MembroResponseDto atualizarMembro(UUID id, MembroRequestDto request) {

		var membro = membroRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("O membro " + id + " não foi encontrado."));

		if (membroRepository.existsByEmailAndIdNot(request.getEmail(), id)) {
			throw new IllegalArgumentException("O e-mail " + request.getEmail() + " já está em uso por outro membro.");
		}

		if (membroRepository.existsByTelefoneAndIdNot(request.getTelefone(), id)) {
			throw new IllegalArgumentException(
					"O telefone " + request.getTelefone() + " já está em uso por outro membro.");
		}

		List<Grupo> novosGrupos = grupoRepository.findAllById(request.getGruposIds());

		if (novosGrupos.size() != request.getGruposIds().size()) {
			throw new IllegalArgumentException("Um ou mais grupos informados não existem.");
		}

		List<Grupo> gruposAntigos = new ArrayList<>(membro.getGrupos());

		gruposAntigos.forEach(grupo -> {
			if (!novosGrupos.contains(grupo)) {
				grupo.getMembros().remove(membro);
			}
		});

		novosGrupos.forEach(grupo -> {
			if (!grupo.getMembros().contains(membro)) {
				grupo.getMembros().add(membro);
			}
		});

		modelMapper.map(request, membro);

		membroRepository.save(membro);
		grupoRepository.saveAll(gruposAntigos);
		grupoRepository.saveAll(novosGrupos);

		return modelMapper.map(membro, MembroResponseDto.class);
	}

	@Override
	public String excluirMembro(UUID id) {

		var membro = membroRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("O membro " + id + " não foi encontrado."));

		membroRepository.delete(membro);

		return "Membro removido com sucesso!";
	}

	@Override
	public MembroResponseDto consultarMembroPorId(UUID id) {

		var membro = membroRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("O membro " + id + " não foi encontrado."));

		return modelMapper.map(membro, MembroResponseDto.class);
	}

	@Override
	public List<MembroResponseDto> consultarMembros() {

		return membroRepository.findAll().stream().map(membro -> modelMapper.map(membro, MembroResponseDto.class))
				.collect(Collectors.toList());
	}

}