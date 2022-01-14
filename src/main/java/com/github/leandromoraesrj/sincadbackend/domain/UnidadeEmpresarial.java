package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.leandromoraesrj.sincadbackend.domain.enuns.TipoPessoaEnum;

@Entity
@Table(name = "unidade_empresarial")
public class UnidadeEmpresarial implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id	
	@SequenceGenerator(name = "se_unidade_empresarial_generator", sequenceName = "se_unidade_empresarial", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_unidade_empresarial_generator")
	@Column(name = "sq_unidade_empresarial")
	private BigDecimal id;	
	@Column(name = "no_razao_social")
	private String razaoSocial;	
	@Column(name = "tp_pessoa")
	private String tipoPessoa;
	@Column(name = "nu_raiz_cnpj")	
	private String raizCNPJ;	
	@Column(name = "nu_cpf")
	private String cpf;
	@OneToMany(mappedBy = "unidadeEmpresarial")
	private List<Estabelecimento> estabelecimentos = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "historico_no_razao_social")
	private List<String> historicoRazaoSocial = new ArrayList<>();
	@OneToMany(mappedBy = "id.unidadeEmpresarial")
	private List<EstabelecimentoPrincipal> estabelecimetosPrincipal = new ArrayList<>();

	public UnidadeEmpresarial() {		
	}

	public UnidadeEmpresarial(BigDecimal id, String razaoSocial, TipoPessoaEnum tipoPessoa, String raizCNPJ, String cpf) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.tipoPessoa = tipoPessoa.getCod();
		this.raizCNPJ = raizCNPJ;
		this.cpf = cpf;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public TipoPessoaEnum getTipoPessoa() {
		return TipoPessoaEnum.toEnum(tipoPessoa);
	}

	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa.getCod();
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
	
	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}
	
	public List<String> getHistoricoRazaoSocial() {
		return historicoRazaoSocial;
	}

	public void setHistoricoRazaoSocial(List<String> historicoRazaoSocial) {
		this.historicoRazaoSocial = historicoRazaoSocial;
	}

	public List<EstabelecimentoPrincipal> getEstabelecimetosPrincipal() {
		return estabelecimetosPrincipal;
	}

	public void setEstabelecimetosPrincipal(List<EstabelecimentoPrincipal> estabelecimetosPrincipal) {
		this.estabelecimetosPrincipal = estabelecimetosPrincipal;
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
