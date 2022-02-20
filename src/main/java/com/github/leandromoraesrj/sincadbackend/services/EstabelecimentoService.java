package com.github.leandromoraesrj.sincadbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.leandromoraesrj.sincadbackend.domain.Estabelecimento;
import com.github.leandromoraesrj.sincadbackend.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	@Autowired
	private EstabelecimentoRepository repo;
	
	public void adicionarEstabelecimento(Estabelecimento estabelecimento) {
		repo.save(estabelecimento);
	}
}
