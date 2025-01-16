package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

		var membro = membroRepository.findById(request.getIdMembro()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdMembro() + " não encontrado."));

		if (convidadoRepository.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("Já existe um convidado cadastrado com o e-mail: " + request.getEmail());
		}

		if (convidadoRepository.existsByTelefone(request.getTelefone())) {
			throw new IllegalArgumentException(
					"Já existe um convidado cadastrado com o telefone: " + request.getTelefone());
		}

		var convidado = modelMapper.map(request, Convidado.class);
		convidado.setId(UUID.randomUUID());
		convidado.setMembro(membro);

		convidadoRepository.save(convidado);

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public ConvidadoResponseDto alterarConvidado(UUID id, ConvidadoRequestDto request) {

		var convidado = convidadoRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Convidado " + request.getIdMembro() + " não encontrado."));

		var membro = membroRepository.findById(request.getIdMembro()).orElseThrow(
				() -> new IllegalArgumentException("Membro " + request.getIdMembro() + " não encontrado."));
		
		if (convidadoRepository.existsByEmailAndIdNot(request.getEmail(), id)) {
	        throw new IllegalArgumentException("O e-mail " + request.getEmail() + " já está em uso por outro convidado.");
	    }
	    
	    if (convidadoRepository.existsByTelefoneAndIdNot(request.getTelefone(), id)) {
	        throw new IllegalArgumentException("O telefone " + request.getTelefone() + " já está em uso por outro convidado.");
	    }
	 
		convidado.setNome(request.getNome());
		convidado.setEmail(request.getEmail());
		convidado.setTelefone(request.getTelefone());
		convidado.setMembro(membro);

		convidadoRepository.save(convidado);

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public String excluirConvidado(UUID id) {

		var convidado = convidadoRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Convidado " + id + " não encontrado."));

		convidadoRepository.delete(convidado);

		return "Convidado removido com sucesso!";
	}

	@Override
	public ConvidadoResponseDto consultarConvidadoPorId(UUID id) {

		var convidado = convidadoRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Convidado " + id + " não encontrado."));

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public List<ConvidadoResponseDto> consultarConvidados() {

		return convidadoRepository.findAll().stream()
				.map(convidado -> modelMapper.map(convidado, ConvidadoResponseDto.class)).collect(Collectors.toList());
	}

}