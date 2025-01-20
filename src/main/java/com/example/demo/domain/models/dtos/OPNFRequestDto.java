package com.example.demo.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import com.example.demo.domain.models.enums.StatusOPNF;

import lombok.Data;

@Data
public class OPNFRequestDto {

	private Double valorTotal;
	private String descricao;
	private Date dataCriacao;
	private StatusOPNF status;
	private UUID idReferencia;
	private UUID idAutor;
	private UUID idBeneficiario;
}
