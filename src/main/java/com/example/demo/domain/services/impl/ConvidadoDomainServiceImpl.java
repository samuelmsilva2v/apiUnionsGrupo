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

		var membro = membroRepository.findById(request.getIdMembro()).get();

		var convidado = modelMapper.map(request, Convidado.class);
		convidado.setIdConvidado(UUID.randomUUID());
		convidado.setMembro(membro);

		convidadoRepository.save(convidado);

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public ConvidadoResponseDto alterarConvidado(UUID id, ConvidadoRequestDto request) {

		var convidado = convidadoRepository.findById(id).get();

		var membro = membroRepository.findById(request.getIdMembro()).get();

		convidado.setNome(request.getNome());
		convidado.setEmail(request.getEmail());
		convidado.setTelefone(request.getTelefone());
		convidado.setMembro(membro);

		convidadoRepository.save(convidado);

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public String excluirConvidado(UUID id) {

		var convidado = convidadoRepository.findById(id).get();

		convidadoRepository.delete(convidado);

		return "Convidado removido com sucesso!";
	}

	@Override
	public ConvidadoResponseDto consultarConvidadoPorId(UUID id) {

		var convidado = convidadoRepository.findById(id).get();

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public List<ConvidadoResponseDto> consultarConvidados() {
		
		return convidadoRepository.findAll().stream()
				.map(convidado -> modelMapper.map(convidado, ConvidadoResponseDto.class)).collect(Collectors.toList());
	}

}
