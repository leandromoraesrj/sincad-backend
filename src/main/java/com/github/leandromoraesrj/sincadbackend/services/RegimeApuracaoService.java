package com.github.leandromoraesrj.sincadbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.leandromoraesrj.sincadbackend.domain.RegimeApuracao;
import com.github.leandromoraesrj.sincadbackend.repositories.RegimeApuracaoRepository;

@Service
public class RegimeApuracaoService {
	@Autowired
	private RegimeApuracaoRepository repo;
	
	public List<RegimeApuracao> listarTodos() {
		return repo.findAll();
	}
	
	public Optional<RegimeApuracao> obter(Integer id) {
		return repo.findById(id);
	}
}