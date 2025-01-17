package com.example.demo.domain.models.dtos;

import java.util.UUID;

import com.example.demo.domain.models.enums.Avaliacao;
import com.example.demo.domain.models.enums.Status;
import com.example.demo.domain.models.enums.TipoReferencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReferenciaRequestDto {

	@NotBlank(message = "O campo observações deve ser preenchido.")
	private String observacoes;

	@NotNull(message = "O campo status é obrigatório.")
	private Status status;

	@NotNull(message = "O campo status é obrigatório.")
	private TipoReferencia tipoReferencia;
	
	@NotNull(message = "O campo status é obrigatório.")
	private Avaliacao avaliacao;
	
	@NotNull(message = "A ID do avaliador é obrigatória.")
	private UUID idAvaliador;
	
	@NotNull(message = "A ID do avaliador é obrigatória.")
	private UUID idAvaliado;
}
