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

import com.example.demo.domain.models.dtos.MembroRequestDto;
import com.example.demo.domain.models.dtos.MembroResponseDto;
import com.example.demo.domain.services.interfaces.MembroDomainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/membros")
public class MembroController {

	@Autowired
	private MembroDomainService membroDomainService;
	
	@PostMapping
	public MembroResponseDto insert(@Valid @RequestBody MembroRequestDto request) {
		return membroDomainService.cadastrarMembro(request);
	}

	@PutMapping("{id}")
	public MembroResponseDto update(@PathVariable UUID id, @RequestBody MembroRequestDto request) {
		return membroDomainService.atualizarMembro(id, request);
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		return membroDomainService.excluirMembro(id);
	}

	@GetMapping("{id}")
	public MembroResponseDto getById(@PathVariable UUID id) {
		return membroDomainService.consultarMembroPorId(id);
	}

	@GetMapping
	public List<MembroResponseDto> getAll() {
		return membroDomainService.consultarMembros();
	}
}
