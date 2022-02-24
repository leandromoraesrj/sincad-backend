package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	private String raizCnpj;
	@Column(name = "nu_cpf")
	private String cpf;
	@OneToMany(mappedBy = "unidadeEmpresarial", cascade = CascadeType.REMOVE)
	private List<Estabelecimento> estabelecimentos = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "historico_no_razao_social")
	private List<String> historicoRazaoSocial = new ArrayList<>();
	@OneToMany(mappedBy = "id.unidadeEmpresarial")
	private List<EstabelecimentoPrincipal> estabelecimetosPrincipal = new ArrayList<>();

	public UnidadeEmpresarial(Long id, String razaoSocial, TipoPessoaEnum tipoPessoa, String raizCnpj, String cpf) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.tipoPessoa = tipoPessoa.getCod();
		this.raizCnpj = raizCnpj;
		this.cpf = cpf;
	}

	public TipoPessoaEnum getTipoPessoa() {
		return TipoPessoaEnum.toEnum(tipoPessoa);
	}

	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa.getCod();
	}
}