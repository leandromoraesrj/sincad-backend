package com.github.leandromoraesrj.sincadbackend.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.leandromoraesrj.sincadbackend.domain.RegimeApuracao;

@Repository
public interface RegimeApuracaoRepository extends JpaRepository<RegimeApuracao, Integer> {
	// Query Methods
	Boolean existsByCodigo(Integer id);

	Optional<RegimeApuracao> findOneByCodigoAndFimIsNull(Integer codigo);

	List<RegimeApuracao> findDistinctByNomeLikeIgnoreCaseAndFimIsNull(String nome);

	List<RegimeApuracao> findDistinctByNomeLikeIgnoreCaseOrCodigoOrderByNomeAscCodigoDesc(String nome, Integer codigo);

	List<RegimeApuracao> findByCodigoInAndFimIsNull(Collection<Integer> codigos);

	// Query
	@Query("select distinct c from RegimeApuracao c where c.fim is null and (upper(c.nome) like upper(:nome) or c.codigo = :codigo) order by c.nome asc, c.codigo desc")
	List<RegimeApuracao> queryDistinctByNomeLikeIgnoreCaseOrCodigoAndFimIsNullOrderByNomeAscCodigoDesc(
			@Param("nome") String nome, @Param("codigo") Integer codigo);

	// QueryNativa
	@Query(value = "select * from Regime_Apuracao c where c.dt_fim is null and c.no_regime_apuracao like ?1% order by c.no_regime_apuracao asc", nativeQuery = true)
	List<RegimeApuracao> queryNativaByNomeLikeAndFimIsNullOrderByNomeAsc(String nome);

	@Transactional
	@Modifying
	@Query("delete from RegimeApuracao u where u.nome = ?1")
	void queryDeleteByName(String nome);
}