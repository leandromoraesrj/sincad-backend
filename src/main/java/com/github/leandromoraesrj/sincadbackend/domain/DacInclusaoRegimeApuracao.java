package com.github.leandromoraesrj.sincadbackend.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dac_inclusao_regime_apuracao")
public class DacInclusaoRegimeApuracao extends Dac {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "sq_regime_apuracao")
	private RegimeApuracao regimeApuracao;
	@Column(name = "dt_inicio")
	private LocalDate inicio;
	
	public DacInclusaoRegimeApuracao() {
		super();
	}

	public DacInclusaoRegimeApuracao(BigDecimal id, String numero, LocalDateTime dataCriacao, Instant dataProcessamento,
			UnidadeEmpresarial unidadeEmpresarial, Estabelecimento estabelecimento, Inscricao inscricao, RegimeApuracao regimeApuracao, LocalDate inicio) {
		super(id, numero, dataCriacao, dataProcessamento, unidadeEmpresarial, estabelecimento, inscricao);
		this.regimeApuracao = regimeApuracao;
		this.inicio = inicio;
	}

	public RegimeApuracao getRegimeApuracao() {
		return regimeApuracao;
	}

	public void setRegimeApuracao(RegimeApuracao regimeApuracao) {
		this.regimeApuracao = regimeApuracao;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	@Override
	public String toString() {
		return "DacInclusaoRegimeApuracao [regimeApuracao=" + regimeApuracao + ", inicio=" + inicio + "]";
	}
}
