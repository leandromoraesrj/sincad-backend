package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "regime_apuracao")
public class RegimeApuracao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "se_regime_apuracao_generator", sequenceName = "se_regime_apuracao", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_regime_apuracao_generator")
	@Column(name = "sq_regime_apuracao")
	private Long id;	
	@Column(name = "co_regime_apuracao")
	private Long codigo;	
	@Column(name = "no_regime_apuracao")
	private String nome;	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date inicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim")
	private Date fim;
	
	public RegimeApuracao() {		
	}

	public RegimeApuracao(Long id, Long codigo, String nome, Date inicio, Date fim) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		RegimeApuracao other = (RegimeApuracao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "RegimeApuracao [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", inicio=" + inicio + ", fim="
				+ fim + "]";
	}
}
