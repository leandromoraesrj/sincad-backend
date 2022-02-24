package com.github.leandromoraesrj.sincadbackend.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum TipoPessoaEnum {
	PESSOA_FISICA("PF", "Pessoa Física"),
	PESSOA_JURIDICA("PJ", "Pessoa Jurídica");

	@Setter
	private String cod;
	@Setter
	private String descricao;

	public static TipoPessoaEnum toEnum(String cod) {
		for (TipoPessoaEnum a : TipoPessoaEnum.values()) {
			if (!cod.equals(null) && a.getCod().equals(cod)) {
				return a;
			}
		}

		return null;
	}
}