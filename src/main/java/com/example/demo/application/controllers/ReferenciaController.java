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

import com.example.demo.domain.models.dtos.ReferenciaRequestDto;
import com.example.demo.domain.models.dtos.ReferenciaResponseDto;
import com.example.demo.domain.services.interfaces.ReferenciaDomainService;

@RestController
@RequestMapping("/api/referencias")
public class ReferenciaController {
	
	@Autowired
	private ReferenciaDomainService referenciaService;
	
	@PostMapping
	public ReferenciaResponseDto post(@RequestBody ReferenciaRequestDto request) {
		return referenciaService.publicarReferencia(request);
	}
	
	@PutMapping("{id}")
	public ReferenciaResponseDto update(@PathVariable UUID idReferencia, @RequestBody ReferenciaRequestDto request) {
		return referenciaService.editarReferencia(idReferencia, request);
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID idReferencia) {
		return referenciaService.excluirReferencia(idReferencia);
	}
	
	@GetMapping("{id}")
	public ReferenciaResponseDto getById(@PathVariable UUID idReferencia) {
		return referenciaService.consultarReferenciaPorId(idReferencia);
	}
	
	@GetMapping
	public List<ReferenciaResponseDto> getAll() {
		return referenciaService.consultarReferencias();
	}

}
