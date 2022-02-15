package com.github.leandromoraesrj.sincadbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.leandromoraesrj.sincadbackend.domain.EstabelecimentoPrincipal;
import com.github.leandromoraesrj.sincadbackend.domain.EstabelecimentoPrincipalPK;

@Repository
public interface EstabelecimentoPrincipalRepository extends JpaRepository<EstabelecimentoPrincipal, EstabelecimentoPrincipalPK> {

}
