package com.example.demo.domain.services.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.OPNFRequestDto;
import com.example.demo.domain.models.dtos.OPNFResponseDto;
import com.example.demo.domain.models.dtos.ReferenciaResponseDto;
import com.example.demo.domain.models.entities.OPNF;
import com.example.demo.domain.services.interfaces.OPNFDomainService;
import com.example.demo.infrastructure.repositories.MembroRepository;
import com.example.demo.infrastructure.repositories.OPNFRepository;
import com.example.demo.infrastructure.repositories.ReferenciaRepository;

@Service
public class OPNFDomainServiceImpl implements OPNFDomainService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OPNFRepository opnfRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private ReferenciaRepository referenciaRepository;

	@Override
	public OPNFResponseDto criarOPNF(OPNFRequestDto request) {

		var autor = membroRepository.findById(request.getIdAutor())
				.orElseThrow(() -> new IllegalArgumentException("Membro " + request.getIdAutor() + " não encontrado."));

		var beneficiario = membroRepository.findById(request.getIdBeneficiario())
				.orElseThrow(() -> new IllegalArgumentException("Membro " + request.getIdAutor() + " não encontrado."));

		var referencia = referenciaRepository.findById(request.getIdReferencia()).orElseThrow(
				() -> new IllegalArgumentException("Referencia " + request.getIdReferencia() + " não encontrada."));

		var opnf = new OPNF();
		opnf.setId(UUID.randomUUID());
		opnf.setValorTotal(request.getValorTotal());
		opnf.setDescricao(request.getDescricao());
		opnf.setDataCriacao(new Date());
		opnf.setStatus(request.getStatus());
		opnf.setReferencia(referencia);
		opnf.setAutor(autor);
		opnf.setBeneficiario(beneficiario);

		opnfRepository.save(opnf);

		return modelMapper.map(opnf, OPNFResponseDto.class);
	}

	@Override
	public OPNFResponseDto alterarOPNF(UUID id, OPNFRequestDto request) {

		var opnf = opnfRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("OPNF " + id + " não encontrada."));

		var autor = membroRepository.findById(request.getIdAutor())
				.orElseThrow(() -> new IllegalArgumentException("Membro " + request.getIdAutor() + " não encontrado."));

		var beneficiario = membroRepository.findById(request.getIdBeneficiario())
				.orElseThrow(() -> new IllegalArgumentException("Membro " + request.getIdAutor() + " não encontrado."));

		var referencia = referenciaRepository.findById(request.getIdReferencia()).orElseThrow(
				() -> new IllegalArgumentException("Referencia " + request.getIdReferencia() + " não encontrada."));

		opnf.setValorTotal(request.getValorTotal());
		opnf.setDescricao(request.getDescricao());
		opnf.setDataCriacao(new Date());
		opnf.setStatus(request.getStatus());
		opnf.setReferencia(referencia);
		opnf.setAutor(autor);
		opnf.setBeneficiario(beneficiario);

		opnfRepository.save(opnf);

		return modelMapper.map(opnf, OPNFResponseDto.class);
	}

	@Override
	public String excluirOPNF(UUID id) {

		var opnf = opnfRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("OPNF " + id + " não encontrada."));

		opnfRepository.delete(opnf);

		return "OPNF excluída com sucesso!";
	}

	@Override
	public OPNFResponseDto consultarOPNFPorId(UUID id) {

		var opnf = opnfRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("OPNF " + id + " não encontrada."));

		return modelMapper.map(opnf, OPNFResponseDto.class);
	}

	@Override
	public List<OPNFResponseDto> consultarOPNFs() {

		return opnfRepository.findAll().stream().map(opnf -> modelMapper.map(opnf, OPNFResponseDto.class))
				.collect(Collectors.toList());
	}

}
