package com.example.demo.domain.models.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_reuniao")
@Data
public class Reuniao {

	@Id
	private UUID idReuniao;
	private Date dataEHora;
	private String local;
	private String motivo;

	@ManyToOne
	@JoinColumn(name = "id_solicitante", nullable = false)
	private Membro solicitante;
	
	@ManyToOne
    @JoinColumn(name = "id_convidado", nullable = false)
	private Membro convidado;
}
