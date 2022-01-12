package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
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
@Table(name = "inscricao_estab_reg_apuracao")
public class InscricaoRegimeApuracao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "se_inscricao_estab_reg_apur_generator", sequenceName = "se_inscricao_estab_reg_apur", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_inscricao_estab_reg_apur_generator")
	@Column(name = "sq_inscricao_estab_reg_apur")
	private Long id;
	//sq_inscricao_estabelecimento
	//sq_regime_apuracao	
	@Column(name = "in_excluido")
	private boolean excluido;
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
	@JoinColumn(name = "sq_regime_apuracao")
	private RegimeApuracao regimeApuracao;
	
	public InscricaoRegimeApuracao() {		
	}

	public InscricaoRegimeApuracao(Long id, boolean excluido, Date inicio, Date fim, Inscricao inscricao,
			RegimeApuracao regimeApuracao) {
		super();
		this.id = id;
		this.excluido = excluido;
		this.inicio = inicio;
		this.fim = fim;
		this.inscricao = inscricao;
		this.regimeApuracao = regimeApuracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
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

	public RegimeApuracao getRegimeApuracao() {
		return regimeApuracao;
	}

	public void setRegimeApuracao(RegimeApuracao regimeApuracao) {
		this.regimeApuracao = regimeApuracao;
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
		InscricaoRegimeApuracao other = (InscricaoRegimeApuracao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "InscricaoRegimeApuracao [id=" + id + ", excluido=" + excluido + ", inicio=" + inicio + ", fim=" + fim
				+ "]";
	}
}