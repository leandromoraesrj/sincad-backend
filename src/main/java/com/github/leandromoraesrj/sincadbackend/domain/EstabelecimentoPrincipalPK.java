package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EstabelecimentoPrincipalPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "sq_unidade_empresarial")
	private UnidadeEmpresarial unidadeEmpresarial;
	@ManyToOne
	@JoinColumn(name = "sq_estabelecmento")
	private Estabelecimento estabelecimento;
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(estabelecimento, unidadeEmpresarial);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstabelecimentoPrincipalPK other = (EstabelecimentoPrincipalPK) obj;
		return Objects.equals(estabelecimento, other.estabelecimento)
				&& Objects.equals(unidadeEmpresarial, other.unidadeEmpresarial);
	}
}
