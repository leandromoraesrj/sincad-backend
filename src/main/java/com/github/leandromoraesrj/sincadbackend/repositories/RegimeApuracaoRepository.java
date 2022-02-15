package com.github.leandromoraesrj.sincadbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.leandromoraesrj.sincadbackend.domain.RegimeApuracao;

@Repository
public interface RegimeApuracaoRepository extends JpaRepository<RegimeApuracao, Integer> {

}