package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arquivo_mei")
public class ArquivoMei implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nu_linha")
	private Long linha;
	@Column(name = "nu_raiz_cnpj")
	private String raizCnpj;

	public ArquivoMei() {
	}

	public ArquivoMei(Long linha, String raizCnpj) {
		this.linha = linha;
		this.raizCnpj = raizCnpj;
	}

	public Long getLinha() {
		return linha;
	}

	public void setLinha(Long linha) {
		this.linha = linha;
	}

	public String getRaizCnpj() {
		return raizCnpj;
	}

	public void setRaizCnpj(String raizCnpj) {
		this.raizCnpj = raizCnpj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(linha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArquivoMei other = (ArquivoMei) obj;
		return Objects.equals(linha, other.linha);
	}

	@Override
	public String toString() {
		return "ArquivoMei [linha=" + linha + ", raizCNPJ=" + raizCnpj + "]";
	}
}
