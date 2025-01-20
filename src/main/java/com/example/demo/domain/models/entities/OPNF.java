package com.example.demo.domain.models.entities;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_opnf")
@Data
public class OPNF {

	@Id
	private UUID id;
	private Double valorTotal;
	private String descricao;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date dataCriacao;

	@ManyToOne
	@JoinColumn(name = "referencia_id", nullable = false)
	private Referencia referencia;

	@ManyToOne
	@JoinColumn(name = "autor_id", nullable = false)
	private Membro autor;
	
	@ManyToOne
    @JoinColumn(name = "beneficiario_id", nullable = false)
	private Membro beneficiario;
}
