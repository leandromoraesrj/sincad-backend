package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dac")
public abstract class Dac implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "se_dac_generator", sequenceName = "se_dac", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_dac_generator")
	@Column(name = "sq_dac")
	private BigDecimal id;
	@Column(name = "nu_dac")
	private String numero;
	@Column(name = "dh_criacao")
	private LocalDateTime dataCriacao;
	@Column(name = "dh_processamento")
	private Instant dataProcessamento;
	@ManyToOne
	@JoinColumn(name = "sq_unidade_empresarial")
	private UnidadeEmpresarial unidadeEmpresarial;
	@ManyToOne
	@JoinColumn(name = "sq_estabelecimento")
	private Estabelecimento estabelecimento;
	@ManyToOne
	@JoinColumn(name = "sq_inscricao_estabelecimento")
	private Inscricao inscricao;	
	
	public Dac() {		
	}

	public Dac(BigDecimal id, String numero, LocalDateTime dataCriacao, Instant dataProcessamento,
			UnidadeEmpresarial unidadeEmpresarial, Estabelecimento estabelecimento, Inscricao inscricao) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataCriacao = dataCriacao;
		this.dataProcessamento = dataProcessamento;
		this.unidadeEmpresarial = unidadeEmpresarial;
		this.estabelecimento = estabelecimento;
		this.inscricao = inscricao;
	}



	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UnidadeEmpresarial getUnidadeEmpresarial() {
		return unidadeEmpresarial;
	}

	public void setUnidadeEmpresarial(UnidadeEmpresarial unidadeEmpresarial) {
		this.unidadeEmpresarial = unidadeEmpresarial;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Instant getDataProcessamento() {
		return dataProcessamento;
	}

	public void setDataProcessamento(Instant dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
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
		Dac other = (Dac) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Dac [id=" + id + ", numero=" + numero + ", dataCriacao=" + dataCriacao + ", dataProcessamento="
				+ dataProcessamento + ", unidadeEmpresarial=" + unidadeEmpresarial + ", estabelecimento="
				+ estabelecimento + ", inscricao=" + inscricao + "]";
	}
}
