package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estabelecimento")
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "se_estabelecimento_generator", sequenceName = "se_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_estabelecimento_generator")
	@Column(name = "sq_estabelecimento")
	private Long id;
	@Column(name = "nu_cnpj")
	private String cnpj;
	@Column(name = "ds_titulo_estabelecimento")
	private String titulo;
	@ManyToOne(optional = false)
	@JoinColumn(name = "sq_unidade_empresarial")
	private UnidadeEmpresarial unidadeEmpresarial;
	@OneToOne(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
	private Inscricao inscricao;
	@ManyToMany
	@JoinTable(name = "estab_tipo_unidade_estab", joinColumns = @JoinColumn(name = "sq_tipo_unid_estabelecimento"), inverseJoinColumns = @JoinColumn(name = "sq_estabelecimento"))
	private Set<TipoUnidadeEstabelecimento> tiposUnidadeEstabelecimento = new HashSet<>();
}