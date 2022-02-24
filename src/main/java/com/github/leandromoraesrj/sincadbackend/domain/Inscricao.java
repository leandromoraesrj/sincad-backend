package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inscricao_estabelecimento")
public class Inscricao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	@Column(name = "nu_inscricao_estadual")
	private Integer numero;
	@Column(name = "dt_concessao_inscricao")
	private LocalDate dataConcessao;
	@OneToOne
	@JoinColumn(name = "sq_inscricao_estabelecimento")
	@MapsId
	private Estabelecimento estabelecimento;
	@OneToMany(mappedBy = "inscricao")
	private List<InscricaoCondicaoInscricaoEstadual> condicoesInscricao = new ArrayList<>();
	@OneToMany(mappedBy = "inscricao")
	private List<InscricaoRegimeApuracao> regimesInscricao = new ArrayList<>();
}