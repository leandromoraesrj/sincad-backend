package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
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
	private Long id;
	@Column(name = "nu_dac")
	private String numero;
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

	public Dac(Long id, String numero, UnidadeEmpresarial unidadeEmpresarial, Estabelecimento estabelecimento,
			Inscricao inscricao) {
		super();
		this.id = id;
		this.numero = numero;
		this.unidadeEmpresarial = unidadeEmpresarial;
		this.estabelecimento = estabelecimento;
		this.inscricao = inscricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return "Dac [id=" + id + ", numero=" + numero + ", unidadeEmpresarial=" + unidadeEmpresarial
				+ ", estabelecimento=" + estabelecimento + ", inscricao=" + inscricao + "]";
	}	
}
