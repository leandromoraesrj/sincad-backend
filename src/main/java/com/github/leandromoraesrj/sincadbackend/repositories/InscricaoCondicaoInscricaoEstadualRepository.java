package com.github.leandromoraesrj.sincadbackend.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.leandromoraesrj.sincadbackend.domain.InscricaoCondicaoInscricaoEstadual;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoCondicaoInscricaoEstadualRepository extends JpaRepository<InscricaoCondicaoInscricaoEstadual, BigDecimal> {

}
