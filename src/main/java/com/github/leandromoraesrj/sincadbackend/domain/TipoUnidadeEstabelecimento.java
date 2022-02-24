package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_unidade_estabelecimento")
public class TipoUnidadeEstabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "se_tipo_unid_estabelecimento_generator", sequenceName = "se_tipo_unid_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_tipo_unid_estabelecimento_generator")
	@Column(name = "sq_tipo_unid_estabelecimento")
	private Integer id;
	@Column(name = "ds_tipo_unid_estabelecimento")
	private String descricao;
	@Column(name = "co_rfb")
	private String codigoRFB;
	@Column(name = "in_sujeito_inscricao_estadual")
	private boolean sujeitoInscricaoEstadual;
	@ManyToMany(mappedBy = "tiposUnidadeEstabelecimento")
	private List<Estabelecimento> estabelecimentos = new ArrayList<>();
}