package com.github.leandromoraesrj.sincadbackend.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.leandromoraesrj.sincadbackend.domain.Dac;

@Repository
public interface DacRepository extends JpaRepository<Dac, BigDecimal> {

}
