package com.example.demo.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReuniaoRequestDto {

	@NotNull(message = "A data e a hora são obrigatórias.")
	private Date dataEHora;
	
	@NotBlank(message = "Informe o local da reunião.")
	private String local;
	
	@NotBlank(message = "Informe o motivo da reunião.")
	private String motivo;
	
	@NotNull(message = "A ID do solicitante é obrigatória.")
	private UUID idSolicitante;
	
	@NotNull(message = "A ID do convidado é obrigatória.")
	private UUID idConvidado;
}
