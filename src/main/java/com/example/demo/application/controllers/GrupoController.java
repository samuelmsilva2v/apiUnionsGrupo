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

import com.example.demo.domain.models.dtos.GrupoRequestDto;
import com.example.demo.domain.models.dtos.GrupoResponseDto;
import com.example.demo.domain.services.interfaces.GrupoDomainService;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

	@Autowired
	private GrupoDomainService grupoDomainService;

	@PostMapping
	public GrupoResponseDto insert(@RequestBody GrupoRequestDto request) {
		return grupoDomainService.cadastrarGrupo(request);
	}

	@PutMapping("{id}")
	public GrupoResponseDto update(@PathVariable UUID id, @RequestBody GrupoRequestDto request) {
		return grupoDomainService.alterarGrupo(id, request);
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		return grupoDomainService.excluirGrupo(id);
	}

	@GetMapping("{id}")
	public GrupoResponseDto getById(@PathVariable UUID id) {
		return grupoDomainService.consultarGrupoPorId(id);
	}

	@GetMapping
	public List<GrupoResponseDto> getAll() {
		return grupoDomainService.consultarGrupos();
	}
}