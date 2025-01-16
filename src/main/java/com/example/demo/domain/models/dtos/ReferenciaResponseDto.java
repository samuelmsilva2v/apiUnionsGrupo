package com.example.demo.domain.models.dtos;

import java.util.UUID;

import com.example.demo.domain.models.enums.Avaliacao;
import com.example.demo.domain.models.enums.Status;
import com.example.demo.domain.models.enums.TipoReferencia;

import lombok.Data;

@Data	
public class ReferenciaResponseDto {

	private UUID id;
	private String observacoes;
	private Status status;
	private TipoReferencia tipoReferencia;
	private Avaliacao avaliacao;
	private MembroResponseDto avaliador;
	private MembroResponseDto avaliado;
}
