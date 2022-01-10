package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_unidade_estabelecimento")
public class TipoUnidadeEstabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "se_tipo_unid_estabelecimento_generator", sequenceName = "se_tipo_unid_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_tipo_unid_estabelecimento_generator")
	@Column(name = "sq_tipo_unid_estabelecimento")
	private Long id;
	@Column(name = "ds_tipo_unid_estabelecimento")
	private String descricao;
	@Column(name = "CO_RFB")
	private String codigoRFB;
	@Column(name = "in_sujeito_inscricao_estadual")
	private boolean sujeitoInscricaoEstadual;
	@ManyToMany(mappedBy = "tiposUnidadeEstabelecimento")
	private List<Estabelecimento> estabelecimentos = new ArrayList<>();

	public TipoUnidadeEstabelecimento() {		
	}

	public TipoUnidadeEstabelecimento(Long id, String descricao, String codigoRFB, boolean sujeitoInscricaoEstadual) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigoRFB = codigoRFB;
		this.sujeitoInscricaoEstadual = sujeitoInscricaoEstadual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoRFB() {
		return codigoRFB;
	}


	public void setCodigoRFB(String codigoRFB) {
		this.codigoRFB = codigoRFB;
	}


	public boolean isSujeitoInscricaoEstadual() {
		return sujeitoInscricaoEstadual;
	}


	public void setSujeitoInscricaoEstadual(boolean sujeitoInscricaoEstadual) {
		this.sujeitoInscricaoEstadual = sujeitoInscricaoEstadual;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
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
		TipoUnidadeEstabelecimento other = (TipoUnidadeEstabelecimento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TipoUnidadeEstabelecimento [id=" + id + ", descricao=" + descricao + "]";
	}
}
