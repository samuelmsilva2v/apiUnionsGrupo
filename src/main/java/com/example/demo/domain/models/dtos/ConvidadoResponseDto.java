package com.example.demo.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ConvidadoResponseDto {

	private UUID idConvidado;
	private String nome;
	private String telefone;
	private String email;
	private String especialidade;
	private UUID idMembro;
}
