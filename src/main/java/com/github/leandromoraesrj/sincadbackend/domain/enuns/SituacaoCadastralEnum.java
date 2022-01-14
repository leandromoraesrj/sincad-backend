package com.github.leandromoraesrj.sincadbackend.domain.enuns;

public enum SituacaoCadastralEnum {
	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo"),
	INEXISTENTE(3, "Inexistente");
	
	private int cod;
	private String descricao;
	
	private SituacaoCadastralEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static SituacaoCadastralEnum toEnum(int cod) {
		for (SituacaoCadastralEnum a: SituacaoCadastralEnum.values()) {
			if (cod != 0 && a.getCod() == cod) {
				return a;
			}
		}
		
		return null;
	}
}
