package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inscricao_condicao_inscricao")
public class InscricaoCondicaoInscricaoEstadual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "se_inscricao_condicao_inscrica_generator", sequenceName = "se_inscricao_condicao_inscrica", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_inscricao_condicao_inscrica_generator")
	@Column(name = "sq_inscricao_condicao_inscrica")
	private BigDecimal id;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date inicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim")
	private Date fim;
	@ManyToOne
	@JoinColumn(name = "sq_inscricao_estabelecimento")
	private Inscricao inscricao;
	@ManyToOne
	@JoinColumn(name = "sq_condicao_inscricao_estadual")
	private CondicaoInscricaoEstadual condicao;

	public InscricaoCondicaoInscricaoEstadual() {
	}

	public InscricaoCondicaoInscricaoEstadual(BigDecimal id, Date inicio, Date fim, Inscricao inscricao, CondicaoInscricaoEstadual condicao) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.inscricao = inscricao;
		this.condicao = condicao;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
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

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public CondicaoInscricaoEstadual getCondicao() {
		return condicao;
	}

	public void setCondicao(CondicaoInscricaoEstadual condicao) {
		this.condicao = condicao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscricaoCondicaoInscricaoEstadual other = (InscricaoCondicaoInscricaoEstadual) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "InscricaoCondicaoInscricaoEstadual [id=" + id + ", inicio=" + inicio + ", fim=" + fim + "]";
	}
}
