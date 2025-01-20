package com.example.demo.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import com.example.demo.domain.models.enums.StatusOPNF;

import lombok.Data;

@Data
public class OPNFResponseDto {
	
	private UUID id;
	private Double valorTotal;
	private String descricao;
	private Date dataCriacao;
	private StatusOPNF status;
	private ReferenciaResponseDto referencia;
	private MembroResponseDto autor;
	private MembroResponseDto beneficiario;
}
