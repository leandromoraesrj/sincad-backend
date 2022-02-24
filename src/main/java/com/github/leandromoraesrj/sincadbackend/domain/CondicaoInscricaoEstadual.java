package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.leandromoraesrj.sincadbackend.domain.enuns.SituacaoCadastralEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "condicao_inscricao_estadual")
public class CondicaoInscricaoEstadual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "se_condicao_inscricao_estadual_generator", sequenceName = "se_condicao_inscricao_estadual", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_condicao_inscricao_estadual_generator")
	@Column(name = "sq_condicao_inscricao_estadual")
	private Integer id;
	@Column(name = "sq_situacao_cadastral")
	private Integer situacaoCadastral;
	@Column(name = "sg_condicao_inscricao_estadual")
	private String sigla;
	@Column(name = "ds_condicao_inscricao_estadual")
	private String descricao;

	public CondicaoInscricaoEstadual(Integer id, SituacaoCadastralEnum situacaoCadastral, String sigla,
			String descricao) {
		this.id = id;
		this.situacaoCadastral = situacaoCadastral.getCod();
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public SituacaoCadastralEnum getSituacaoCadastral() {
		return SituacaoCadastralEnum.toEnum(situacaoCadastral);
	}

	public void setSituacaoCadastral(SituacaoCadastralEnum situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral.getCod();
	}
}