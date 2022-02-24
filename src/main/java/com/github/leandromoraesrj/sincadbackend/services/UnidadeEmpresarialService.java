package com.github.leandromoraesrj.sincadbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.leandromoraesrj.sincadbackend.domain.UnidadeEmpresarial;
import com.github.leandromoraesrj.sincadbackend.repositories.UnidadeEmpresarialRespository;

@Service
public class UnidadeEmpresarialService {
	@Autowired
	private UnidadeEmpresarialRespository repo;

	public void adicionarEmpresa(UnidadeEmpresarial unidade) {
		repo.save(unidade);
	}
}