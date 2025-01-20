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

import com.example.demo.domain.models.dtos.OPNFRequestDto;
import com.example.demo.domain.models.dtos.OPNFResponseDto;
import com.example.demo.domain.services.interfaces.OPNFDomainService;

@RestController
@RequestMapping("/api/opnf")
public class OPNFController {

	@Autowired
	private OPNFDomainService opnfDomainService;
	
	@PostMapping
	public OPNFResponseDto post(@RequestBody OPNFRequestDto request) {
		return opnfDomainService.criarOPNF(request);
	}
	
	@PutMapping("{id}")
	public OPNFResponseDto put(@PathVariable UUID id, @RequestBody OPNFRequestDto request) {
		return opnfDomainService.alterarOPNF(id, request);
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		return opnfDomainService.excluirOPNF(id);
	}
	
	@GetMapping("{id}")
	public OPNFResponseDto getById(@PathVariable UUID id) {
		return opnfDomainService.consultarOPNFPorId(id);
	}
	
	@GetMapping
	public List<OPNFResponseDto> getAll() {
		return opnfDomainService.consultarOPNFs();
	}
}