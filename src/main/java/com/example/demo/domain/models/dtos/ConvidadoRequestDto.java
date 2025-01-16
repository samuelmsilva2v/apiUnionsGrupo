package com.example.demo.domain.models.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ConvidadoRequestDto {


	@NotBlank(message = "O nome do convidado é obrigatório.")
	@Size(max = 100, message = "O nome do convidado deve ter no máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O telefone do convidado é obrigatório.")
	@Pattern(regexp = "^\\d{2} 9\\d{4}-\\d{4}$", message = "O número deve ser informado no formato: XX XXXXX-XXXX ")
	private String telefone;
	
	@Email
	@NotBlank(message = "O e-mail do convidado é obrigatório.")
	private String email;
	
	@NotBlank(message = "A especialidade/profissão do convidado é obrigatória.")
	@Size(max = 50, message = "A especialidade/profissão deve ter no máximo 50 caracteres.")
	private String especialidade;
	
	private UUID idMembro;
}
