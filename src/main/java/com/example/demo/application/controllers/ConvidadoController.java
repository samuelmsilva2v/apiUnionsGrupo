package com.example.demo.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.models.dtos.ConvidadoRequestDto;
import com.example.demo.domain.models.dtos.ConvidadoResponseDto;
import com.example.demo.domain.services.interfaces.ConvidadoDomainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/convidados")
public class ConvidadoController {

	@Autowired
	private ConvidadoDomainService convidadoDomainService;
	
	@PostMapping
	public ConvidadoResponseDto insert(@Valid @RequestBody ConvidadoRequestDto request) {
		return convidadoDomainService.cadastrarConvidado(request);
	}

	@PutMapping("{id}")
	public ConvidadoResponseDto update(@PathVariable UUID id, @Valid @RequestBody ConvidadoRequestDto request) {
		return convidadoDomainService.alterarConvidado(id, request);
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		return convidadoDomainService.excluirConvidado(id);
	}

	@GetMapping("{id}")
	public ConvidadoResponseDto getById(@PathVariable UUID id) {
		return convidadoDomainService.consultarConvidadoPorId(id);
	}

	@GetMapping
	public List<ConvidadoResponseDto> getAll() {
		return convidadoDomainService.consultarConvidados();
	}
}