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
@Table(name = "unidade_empresarial")
public class UnidadeEmpresarial implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id	
	@SequenceGenerator(name = "se_unidade_empresarial_generator", sequenceName = "se_unidade_empresarial", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_unidade_empresarial_generator")
	@Column(name = "sq_unidade_empresarial")
	private Long id;	
	@Column(name = "no_razao_social")
	private String razaoSocial;	
	@Column(name = "tp_pessoa")
	private String tipoPessoa;
	@Column(name = "nu_raiz_cnpj")	
	private String raizCNPJ;	
	@Column(name = "nu_cpf")
	private String cpf;
	
	public UnidadeEmpresarial() {		
	}

	public UnidadeEmpresarial(Long id, String razaoSocial, String tipoPessoa, String raizCNPJ, String cpf) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.tipoPessoa = tipoPessoa;
		this.raizCNPJ = raizCNPJ;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getRaizCNPJ() {
		return raizCNPJ;
	}

	public void setRaizCNPJ(String raizCNPJ) {
		this.raizCNPJ = raizCNPJ;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		UnidadeEmpresarial other = (UnidadeEmpresarial) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "UnidadeEmpresarial [id=" + id + ", razaoSocial=" + razaoSocial + ", tipoPessoa=" + tipoPessoa
				+ ", raizCNPJ=" + raizCNPJ + ", cpf=" + cpf + "]";
	}
}
