package com.example.demo.domain.models.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_membro")
@Data
public class Membro {

	@Id
	private UUID idMembro;
	private String nome;
	private String email;
	private String telefone;
	private String empresa;
	private String curriculo;
	private String siteEmpresa;

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "membro_grupo", joinColumns = @JoinColumn(name = "membro_id"), inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<Grupo> grupos;

}
