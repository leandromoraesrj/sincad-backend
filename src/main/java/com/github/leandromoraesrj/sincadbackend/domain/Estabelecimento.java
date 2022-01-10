package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estabelecimento")
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "se_estabelecimento_generator", sequenceName = "se_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_estabelecimento_generator")
	@Column(name = "sq_estabelecimento")
	private Long id;
	@Column(name = "nu_cnpj")
	private String cnpj;
	@Column(name = "ds_titulo_estabelecimento")
	private String titulo;
	@ManyToOne
	@JoinColumn(name = "sq_unidade_empresarial")
	private UnidadeEmpresarial unidadeEmpresarial;
	@OneToMany(mappedBy = "estabelecimento")
	private List<Inscricao> inscricoes = new ArrayList<>();
	@ManyToMany
	@JoinTable(name = "estab_tipo_unidade_estab",
			  joinColumns = @JoinColumn(name = "sq_tipo_unid_estabelecimento"),
			  inverseJoinColumns = @JoinColumn(name = "sq_estabelecimento"))
	private Set<TipoUnidadeEstabelecimento> tiposUnidadeEstabelecimento = new HashSet<>();
	
	public Estabelecimento() {		
	}

	public Estabelecimento(Long id, String cnpj, String titulo, UnidadeEmpresarial unidadeEmpresarial) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.titulo = titulo;
		this.unidadeEmpresarial = unidadeEmpresarial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public UnidadeEmpresarial getUnidadeEmpresarial() {
		return unidadeEmpresarial;
	}

	public void setUnidadeEmpresarial(UnidadeEmpresarial unidadeEmpresarial) {
		this.unidadeEmpresarial = unidadeEmpresarial;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	
	public Set<TipoUnidadeEstabelecimento> getTiposUnidadeEstabelecimento() {
		return tiposUnidadeEstabelecimento;
	}

	public void setTiposUnidadeEstabelecimento(Set<TipoUnidadeEstabelecimento> tiposUnidadeEstabelecimento) {
		this.tiposUnidadeEstabelecimento = tiposUnidadeEstabelecimento;
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
		Estabelecimento other = (Estabelecimento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", cnpj=" + cnpj + ", titulo=" + titulo + "]";
	}		
}
