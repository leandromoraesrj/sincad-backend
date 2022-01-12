package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inscricao_estabelecimento")
public class Inscricao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	@Column(name = "nu_inscricao_estadual")
	private Long numero;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_concessao_inscricao")
	private Date dataConcessao;
	@OneToOne
	@JoinColumn(name = "sq_inscricao_estabelecimento")
	@MapsId
	private Estabelecimento estabelecimento;
	@OneToMany(mappedBy = "inscricao")
	private List<InscricaoCondicaoInscricaoEstadual> condicoesInscricao = new ArrayList<>();
	@OneToMany(mappedBy = "inscricao")
	private List<InscricaoRegimeApuracao> regimesInscricao = new ArrayList<>();

	public Inscricao() {		
	}

	public Inscricao(Long id, Long numero, Date dataConcessao, Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataConcessao = dataConcessao;
		this.estabelecimento = estabelecimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDataConcessao() {
		return dataConcessao;
	}

	public void setDataConcessao(Date dataConcessao) {
		this.dataConcessao = dataConcessao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	public List<InscricaoCondicaoInscricaoEstadual> getCondicoesInscricao() {
		return condicoesInscricao;
	}

	public void setCondicoesInscricao(List<InscricaoCondicaoInscricaoEstadual> condicoesInscricao) {
		this.condicoesInscricao = condicoesInscricao;
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
		Inscricao other = (Inscricao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Inscricao [id=" + id + ", numero=" + numero + ", dataConcessao=" + dataConcessao + "]";
	}
}
