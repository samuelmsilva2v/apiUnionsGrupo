package com.example.demo.domain.models.dtos;

import java.util.UUID;

import com.example.demo.domain.models.entities.Membro;
import com.example.demo.domain.models.enums.Avaliacao;
import com.example.demo.domain.models.enums.Status;
import com.example.demo.domain.models.enums.TipoReferencia;

import lombok.Data;

@Data	
public class ReferenciaResponseDto {

	private UUID idReferencia;
	private String observacoes;
	private Status status;
	private TipoReferencia tipoReferencia;
	private Avaliacao avaliacao;
	private Membro avaliador;
	private Membro avaliado;
}
