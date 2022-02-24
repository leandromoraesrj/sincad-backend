package com.github.leandromoraesrj.sincadbackend.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.leandromoraesrj.sincadbackend.domain.UnidadeEmpresarial;

@Repository
public interface UnidadeEmpresarialRespository extends JpaRepository<UnidadeEmpresarial, BigDecimal> {

}