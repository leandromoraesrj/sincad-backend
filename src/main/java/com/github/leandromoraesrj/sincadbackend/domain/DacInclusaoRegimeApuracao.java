package com.github.leandromoraesrj.sincadbackend.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dac_inclusao_regime_apuracao")
public class DacInclusaoRegimeApuracao extends Dac {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "sq_regime_apuracao")
	private RegimeApuracao regimeApuracao;
	@Column(name = "dt_inicio")
	private LocalDate inicio;
}