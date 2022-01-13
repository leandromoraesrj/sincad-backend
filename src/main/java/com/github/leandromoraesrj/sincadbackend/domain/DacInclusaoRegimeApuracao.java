package com.github.leandromoraesrj.sincadbackend.domain;

import java.math.BigDecimal;
import java.util.Date;

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
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date inicio;
	
	public DacInclusaoRegimeApuracao() {
		super();
	}

	public DacInclusaoRegimeApuracao(BigDecimal id, String numero, UnidadeEmpresarial unidadeEmpresarial,
			Estabelecimento estabelecimento, Inscricao inscricao, RegimeApuracao regimeApuracao, Date inicio) {
		super(id, numero, unidadeEmpresarial, estabelecimento, inscricao);
		this.regimeApuracao = regimeApuracao;	
		this.inicio = inicio;
	}

	public RegimeApuracao getRegimeApuracao() {
		return regimeApuracao;
	}

	public void setRegimeApuracao(RegimeApuracao regimeApuracao) {
		this.regimeApuracao = regimeApuracao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	@Override
	public String toString() {
		return "DacInclusaoRegimeApuracao [regimeApuracao=" + regimeApuracao + ", inicio=" + inicio + "]";
	}
}
