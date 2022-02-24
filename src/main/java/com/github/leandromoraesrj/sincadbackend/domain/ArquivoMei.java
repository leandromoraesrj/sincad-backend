package com.github.leandromoraesrj.sincadbackend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "arquivo_mei")
public class ArquivoMei implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nu_linha")
	private Long linha;
	@Column(name = "nu_raiz_cnpj")
	private String raizCnpj;
}