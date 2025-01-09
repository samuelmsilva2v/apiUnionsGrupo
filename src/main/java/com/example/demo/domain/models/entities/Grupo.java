package com.example.demo.domain.models.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_grupo")
@Data
public class Grupo {

	@Id
	private UUID idGrupo;
	private String nome;
	
	@ManyToMany(mappedBy = "grupos")
	private List<Membro> membros;
}
