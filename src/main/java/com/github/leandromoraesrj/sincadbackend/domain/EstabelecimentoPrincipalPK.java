package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class EstabelecimentoPrincipalPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "sq_unidade_empresarial")
	private UnidadeEmpresarial unidadeEmpresarial;
	@ManyToOne
	@JoinColumn(name = "sq_estabelecmento")
	private Estabelecimento estabelecimento;
}
