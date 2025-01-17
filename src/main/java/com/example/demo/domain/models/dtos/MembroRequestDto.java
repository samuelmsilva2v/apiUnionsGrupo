package com.example.demo.domain.models.dtos;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MembroRequestDto {

	private String nome;
	
	@Email(message = "Informe um e-mail válido.")
	@NotBlank(message = "O e-mail do membro é obrigatório.")
	private String email;
	
	@NotBlank(message = "O telefone do membro é obrigatório.")
	@Pattern(regexp = "^\\d{2} 9\\d{4}-\\d{4}$", message = "O número deve ser informado no formato: XX XXXXX-XXXX ")
	private String telefone;
	
	@Size(min = 4, max = 100, message = "O nome da empresa deve ter entre 4 e 100 caracteres." )
	private String empresa;
	
	@NotBlank(message = "O preenchimento do currículo é obrigatório.")
	private String curriculo;
	
	@Size(min = 4, max = 100, message = "O site da empresa deve ter entre 4 e 100 caracteres." )
	private String siteEmpresa;
	
	private List<UUID> gruposIds;
}