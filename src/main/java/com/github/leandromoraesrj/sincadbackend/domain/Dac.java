package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dac")
public abstract class Dac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "se_dac_generator", sequenceName = "se_dac", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_dac_generator")
	@Column(name = "sq_dac")
	private Long id;
	@Column(name = "nu_dac")
	private String numero;
	@Column(name = "dh_criacao")
	private LocalDateTime dataCriacao;
	@Column(name = "dh_processamento")
	private Instant dataProcessamento;
	@ManyToOne
	@JoinColumn(name = "sq_unidade_empresarial")
	private UnidadeEmpresarial unidadeEmpresarial;
	@ManyToOne
	@JoinColumn(name = "sq_estabelecimento")
	private Estabelecimento estabelecimento;
	@ManyToOne
	@JoinColumn(name = "sq_inscricao_estabelecimento")
	private Inscricao inscricao;
}