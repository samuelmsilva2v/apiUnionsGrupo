package com.example.demo.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class GrupoResponseDto {

	private UUID id;
	private String nome;
	// TODO private List<MembroResponseDto> membros;
}
