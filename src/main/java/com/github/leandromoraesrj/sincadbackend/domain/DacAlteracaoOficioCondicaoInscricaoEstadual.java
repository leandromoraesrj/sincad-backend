package com.github.leandromoraesrj.sincadbackend.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dac_alter_cond_insc_oficio")
public class DacAlteracaoOficioCondicaoInscricaoEstadual extends Dac {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "sq_condicao_inscricao_estadual")
	private CondicaoInscricaoEstadual condicaaoInscricaoEstadual;
	@Column(name = "dt_inicio")
	private LocalDate inicio;
	@Column(name = "dt_fim")
	private LocalDate fim;
}