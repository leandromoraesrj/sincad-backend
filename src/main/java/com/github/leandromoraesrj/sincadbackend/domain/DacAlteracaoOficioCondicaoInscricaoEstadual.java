package com.github.leandromoraesrj.sincadbackend.domain;

import java.util.Date;

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
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date inicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim")
	private Date fim;
	
	public DacAlteracaoOficioCondicaoInscricaoEstadual() {
		super();
	}

	public DacAlteracaoOficioCondicaoInscricaoEstadual(Long id, String numero, UnidadeEmpresarial unidadeEmpresarial,
			Estabelecimento estabelecimento, Inscricao inscricao, CondicaoInscricaoEstadual condicaaoInscricaoEstadual,
			Date inicio, Date fim) {
		super(id, numero, unidadeEmpresarial, estabelecimento, inscricao);
		this.condicaaoInscricaoEstadual = condicaaoInscricaoEstadual;
		this.inicio = inicio;
		this.fim = fim;
	}

	public CondicaoInscricaoEstadual getCondicaaoInscricaoEstadual() {
		return condicaaoInscricaoEstadual;
	}

	public void setCondicaaoInscricaoEstadual(CondicaoInscricaoEstadual condicaaoInscricaoEstadual) {
		this.condicaaoInscricaoEstadual = condicaaoInscricaoEstadual;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	@Override
	public String toString() {
		return "DacAlteracaoOficioCondicaoInscricaoEstadual [condicaaoInscricaoEstadual=" + condicaaoInscricaoEstadual
				+ ", inicio=" + inicio + ", fim=" + fim + "]";
	}		
}
