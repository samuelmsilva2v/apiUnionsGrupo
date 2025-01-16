package com.example.demo.domain.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_convidado")
@Data
public class Convidado {

	@Id
	private UUID id;
	@Column(length = 100)
	private String nome;
	
	@Column(unique = true)
	private String telefone;
	@Column(length = 100, unique = true)
	private String email;
	@Column(length = 50)
	private String especialidade;
	
	@ManyToOne
    @JoinColumn(name = "membro_id", nullable = false)
    private Membro membro;
}
