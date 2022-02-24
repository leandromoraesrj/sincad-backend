package com.github.leandromoraesrj.sincadbackend.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum SituacaoCadastralEnum {
	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo"),
	INEXISTENTE(3, "Inexistente");

	@Setter
	private int cod;
	@Setter
	private String descricao;

	public static SituacaoCadastralEnum toEnum(int cod) {
		for (SituacaoCadastralEnum a : SituacaoCadastralEnum.values()) {
			if (cod != 0 && a.getCod() == cod) {
				return a;
			}
		}

		return null;
	}
}