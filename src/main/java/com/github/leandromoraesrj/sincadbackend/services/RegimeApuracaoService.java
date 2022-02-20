package com.github.leandromoraesrj.sincadbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.leandromoraesrj.sincadbackend.domain.RegimeApuracao;
import com.github.leandromoraesrj.sincadbackend.repositories.RegimeApuracaoRepository;

@Service
public class RegimeApuracaoService {
	@Autowired
	private RegimeApuracaoRepository repo;
	
	public List<RegimeApuracao> listarTodos() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "nome", "inicio"));
	}	

	public Optional<RegimeApuracao> obter(Integer id) {
		return repo.findById(id);
	}
	
	public Boolean existe(Integer codigo) {
		return repo.existsByCodigo(codigo);
	}
	
	public Optional<RegimeApuracao> obterPorCodigo(Integer codigo) {
		return repo.findOneByCodigoAndFimIsNull(codigo);
	}
	
	public List<RegimeApuracao> consultarPorNome(String nome) {
		return repo.findDistinctByNomeLikeIgnoreCaseAndFimIsNull(nome+"%");
	}
	
	public List<RegimeApuracao> consultarPorNomeOuCodigo(String nome, Integer codigo) {
		return repo.findDistinctByNomeLikeIgnoreCaseOrCodigoOrderByNomeAscCodigoDesc(nome+"%", codigo);
	}
	
	public List<RegimeApuracao> consultarPorCodigos(List<Integer> codigos) {
		return repo.findByCodigoInAndFimIsNull(codigos);
	}
	
	public List<RegimeApuracao> consultarPorIds(List<Integer> ids) {
		return repo.findAllById(ids);
	}
	
	public void salvarTodos(List<RegimeApuracao> regimes) {
		repo.saveAll(regimes);
	}
	
	public void delete(Integer id) {
		if (repo.existsById(id)) repo.deleteById(id);		
	}
	
	public void deleteTodos() {
		repo.deleteAll();
	}
	
	public List<RegimeApuracao> consultarPorNomeOuCodigoVigente(String nome, Integer codigo) {
		return repo.queryDistinctByNomeLikeIgnoreCaseOrCodigoAndFimIsNullOrderByNomeAscCodigoDesc(nome+"%", codigo);
	}
	
	public List<RegimeApuracao> consultarPorNomeVigente(String nome) {
		return repo.queryNativaByNomeLikeAndFimIsNullOrderByNomeAsc(nome.toUpperCase());
	}
	
	public void deletePorNome(String nome) {
		repo.queryDeleteByName(nome);
	}
}