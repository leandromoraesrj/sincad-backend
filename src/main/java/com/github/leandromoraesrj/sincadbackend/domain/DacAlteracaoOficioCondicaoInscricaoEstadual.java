package com.github.leandromoraesrj.sincadbackend.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	public DacAlteracaoOficioCondicaoInscricaoEstadual() {
		super();
	}

	public DacAlteracaoOficioCondicaoInscricaoEstadual(BigDecimal id, String numero, LocalDateTime dataCriacao,
			Instant dataProcessamento, UnidadeEmpresarial unidadeEmpresarial, Estabelecimento estabelecimento,
			Inscricao inscricao, CondicaoInscricaoEstadual condicaoInscricaoEstadual, LocalDate inicio, LocalDate fim) {
		super(id, numero, dataCriacao, dataProcessamento, unidadeEmpresarial, estabelecimento, inscricao);
		this.condicaaoInscricaoEstadual = condicaoInscricaoEstadual;
		this.inicio = inicio;
		this.fim = fim;
	}


	public CondicaoInscricaoEstadual getCondicaaoInscricaoEstadual() {
		return condicaaoInscricaoEstadual;
	}

	public void setCondicaaoInscricaoEstadual(CondicaoInscricaoEstadual condicaaoInscricaoEstadual) {
		this.condicaaoInscricaoEstadual = condicaaoInscricaoEstadual;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	@Override
	public String toString() {
		return "DacAlteracaoOficioCondicaoInscricaoEstadual [condicaaoInscricaoEstadual=" + condicaaoInscricaoEstadual
				+ ", inicio=" + inicio + ", fim=" + fim + "]";
	}		
}
