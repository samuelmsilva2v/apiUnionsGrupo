package com.example.demo.domain.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GrupoRequestDto {

	@NotBlank(message = "O nome do grupo é obrigatório.")
	@Size(min = 4, max = 100, message = "O nome do grupo deve ter no máximo 100 caracteres." )
	private String nome;
}
