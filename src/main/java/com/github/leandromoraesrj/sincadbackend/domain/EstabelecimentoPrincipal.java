package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "estabelecimento_principal")
public class EstabelecimentoPrincipal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EstabelecimentoPrincipalPK  id = new EstabelecimentoPrincipalPK();
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date inicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim")
	private Date fim;
	
	public EstabelecimentoPrincipal() {		
	}

	public EstabelecimentoPrincipal(UnidadeEmpresarial unidadeEmpresarial, Estabelecimento estabelecimento, Date inicio, Date fim) {
		super();
		this.id.setUnidadeEmpresarial(unidadeEmpresarial);
		this.id.setEstabelecimento(estabelecimento);		
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public UnidadeEmpresarial getUnidadeEmpresarial() {
		return id.getUnidadeEmpresarial();
	}
	
	public void setUnidadeEmpresarial(UnidadeEmpresarial unidadeEmpresarial) {
		id.setUnidadeEmpresarial(unidadeEmpresarial);		
	}
	
	public Estabelecimento getEstabelecimento() {
		return id.getEstabelecimento();
	}
	
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		id.setEstabelecimento(estabelecimento);
	}

	public EstabelecimentoPrincipalPK getId() {
		return id;
	}

	public void setId(EstabelecimentoPrincipalPK id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
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
		EstabelecimentoPrincipal other = (EstabelecimentoPrincipal) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "EstabelecimentoPrincipal [id=" + id + ", inicio=" + inicio + ", fim=" + fim + "]";
	}
}
