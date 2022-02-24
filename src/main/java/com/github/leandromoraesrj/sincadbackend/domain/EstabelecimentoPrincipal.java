package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "estabelecimento_principal")
public class EstabelecimentoPrincipal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstabelecimentoPrincipalPK id = new EstabelecimentoPrincipalPK();
	@Column(name = "dt_inicio")
	private LocalDate inicio;
	@Column(name = "dt_fim")
	private LocalDate fim;

	public EstabelecimentoPrincipal(UnidadeEmpresarial unidadeEmpresarial, Estabelecimento estabelecimento,
			LocalDate inicio, LocalDate fim) {
		this.id.setUnidadeEmpresarial(unidadeEmpresarial);
		this.id.setEstabelecimento(estabelecimento);
		this.inicio = inicio;
		this.fim = fim;
	}
}