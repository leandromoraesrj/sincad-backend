package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regime_apuracao")
public class RegimeApuracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "se_regime_apuracao_generator", sequenceName = "se_regime_apuracao", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se_regime_apuracao_generator")
	@Column(name = "sq_regime_apuracao")
	private Integer id;
	@Column(name = "co_regime_apuracao")
	private Integer codigo;
	@Column(name = "no_regime_apuracao")
	private String nome;
	@Column(name = "dt_inicio")
	private LocalDate inicio;
	@Column(name = "dt_fim")
	private LocalDate fim;
}