package com.example.demo.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class ReuniaoRequestDto {

	private Date dataEHora;
	private String local;
	private String motivo;
	private UUID idSolicitante;
	private UUID idConvidado;
}
