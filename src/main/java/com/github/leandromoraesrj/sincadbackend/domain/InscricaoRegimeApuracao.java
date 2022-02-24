package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inscricao_estab_reg_apuracao")
public class InscricaoRegimeApuracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "se_inscricao_estab_reg_apur_generator", sequenceName = "se_inscricao_estab_reg_apur", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_inscricao_estab_reg_apur_generator")
	@Column(name = "sq_inscricao_estab_reg_apur")
	private Long id;
	@Column(name = "in_excluido")
	private boolean excluido;
	@Column(name = "dt_inicio")
	private LocalDate inicio;
	@Column(name = "dt_fim")
	private LocalDate fim;
	@ManyToOne
	@JoinColumn(name = "sq_inscricao_estabelecimento")
	private Inscricao inscricao;
	@ManyToOne
	@JoinColumn(name = "sq_regime_apuracao")
	private RegimeApuracao regimeApuracao;
}