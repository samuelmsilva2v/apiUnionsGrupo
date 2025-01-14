package com.example.demo.domain.models.entities;

import java.util.UUID;

import com.example.demo.domain.models.enums.Avaliacao;
import com.example.demo.domain.models.enums.Status;
import com.example.demo.domain.models.enums.TipoReferencia;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Referencia {

	@Id
	private UUID idReferencia;
	private String observacoes;
	private Status status;
	private TipoReferencia tipoReferencia;
	private Avaliacao avaliacao;

	@ManyToOne
	@JoinColumn(name = "id_avaliador", nullable = false)
	private Membro avaliador;
	@ManyToOne
	@JoinColumn(name = "id_avaliado", nullable = false)
	private Membro avaliado;
}
