package com.example.demo.domain.models.entities;

import java.util.UUID;

import com.example.demo.domain.models.enums.Avaliacao;
import com.example.demo.domain.models.enums.Status;
import com.example.demo.domain.models.enums.TipoReferencia;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_referencia")
@Data
public class Referencia {

	@Id
	private UUID idReferencia;
	private String observacoes;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private TipoReferencia tipoReferencia;
	
	@Enumerated(EnumType.STRING)
	private Avaliacao avaliacao;

	@ManyToOne
	@JoinColumn(name = "id_avaliador", nullable = false)
	private Membro avaliador;
	@ManyToOne
	@JoinColumn(name = "id_avaliado", nullable = false)
	private Membro avaliado;
}
