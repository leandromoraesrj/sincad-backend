package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "condicao_inscricao_estadual")
public class CondicaoInscricaoEstadual implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "se_condicao_inscricao_estadual_generator", sequenceName = "se_condicao_inscricao_estadual", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_condicao_inscricao_estadual_generator")
	@Column(name = "sq_condicao_inscricao_estadual")
	private int id;
	@Column(name = "sq_situacao_cadastral")
	private Long situacaoCadastral;
	@Column(name = "sg_condicao_inscricao_estadual")
	private String sigla;
	@Column(name = "ds_condicao_inscricao_estadual")
	private String descricao;
	
	public CondicaoInscricaoEstadual() {		
	}

	public CondicaoInscricaoEstadual(int id, Long situacaoCadastral, String sigla, String descricao) {
		super();
		this.id = id;
		this.situacaoCadastral = situacaoCadastral;
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getSituacaoCadastral() {
		return situacaoCadastral;
	}

	public void setSituacaoCadastral(Long situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		CondicaoInscricaoEstadual other = (CondicaoInscricaoEstadual) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CondicaoInscricaoEstadual [id=" + id + ", situacaoCadastral=" + situacaoCadastral + ", sigla=" + sigla
				+ ", descricao=" + descricao + "]";
	}
}
