package com.github.leandromoraesrj.sincadbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.leandromoraesrj.sincadbackend.domain.CondicaoInscricaoEstadual;

@Repository
public interface CondicaoInscricaoEstadualRepository extends JpaRepository<CondicaoInscricaoEstadual, Integer> {

}