package com.github.leandromoraesrj.sincadbackend.domain.enuns;

public enum TipoPessoaEnum {
	PESSOA_FISICA("PF", "Pessoa Física"),
	PESSOA_JURIDICA("PJ", "Pessoa Jurídica");
	
	private String cod;
	private String descricao;
	
	private TipoPessoaEnum(String cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoPessoaEnum toEnum(String cod) {
		for (TipoPessoaEnum a: TipoPessoaEnum.values()) {
			if (!cod.equals(null) && a.getCod().equals(cod)) {
				return a;
			}
		}
		
		return null;
	}
}
