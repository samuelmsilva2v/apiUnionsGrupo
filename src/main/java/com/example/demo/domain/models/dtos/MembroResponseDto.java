package com.example.demo.domain.models.dtos;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.entities.Grupo;

import lombok.Data;

@Data
public class MembroResponseDto {

	private UUID idMembro;
	private String nome;
	private String email;
	private String telefone;
	private String empresa;
	private String curriculo;
	private String siteEmpresa;
	private List<Grupo> grupos;
}
