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

import com.example.demo.domain.models.dtos.ReuniaoRequestDto;
import com.example.demo.domain.models.dtos.ReuniaoResponseDto;
import com.example.demo.domain.services.interfaces.ReuniaoDomainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reunioes")
public class ReuniaoController {

	@Autowired
	private ReuniaoDomainService reuniaoDomainService;
	
	@PostMapping
	public ReuniaoResponseDto post(@Valid @RequestBody ReuniaoRequestDto request) {
		return reuniaoDomainService.marcarReuniao(request);
	}

	@PutMapping("{id}")
	public ReuniaoResponseDto update(@PathVariable UUID id, @Valid @RequestBody ReuniaoRequestDto request) {
		return reuniaoDomainService.alterarReuniao(id, request);
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		return reuniaoDomainService.desmarcarReuniao(id);
	}

	@GetMapping("{id}")
	public ReuniaoResponseDto getById(@PathVariable UUID id) {
		return reuniaoDomainService.consultarReuniaoPorId(id);
	}

	@GetMapping
	public List<ReuniaoResponseDto> getAll() {
		return reuniaoDomainService.consultarReunioes();
	}
}
