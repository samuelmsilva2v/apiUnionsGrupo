package com.example.demo.domain.models.dtos;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class MembroRequestDto {

	private String nome;
	private String email;
	private String telefone;
	private String empresa;
	private String curriculo;
	private String siteEmpresa;
	private List<UUID> gruposIds;
}
