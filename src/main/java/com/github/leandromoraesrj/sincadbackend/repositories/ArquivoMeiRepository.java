package com.github.leandromoraesrj.sincadbackend.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.leandromoraesrj.sincadbackend.domain.ArquivoMei;

@Repository
public class ArquivoMeiRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	private static final String SQL_PERSISTE_LINHA = "INSERT INTO ARQUIVO_MEI (NU_LINHA, NU_RAIZ_CNPJ) VALUES (:NU_LINHA,:NU_RAIZ_CNPJ)";
	private static final String SQL_PREPARED_PERSISTE_LINHA = "INSERT INTO ARQUIVO_MEI (NU_LINHA, NU_RAIZ_CNPJ) VALUES (?,?)";

	public void persistirLinhas(List<ArquivoMei> linhas) {
		persistirLinhas1(linhas);
	}

	// Término da importação do arquivo em: 199 segundos
	public void persistirLinhas2(List<ArquivoMei> linhas) {
		List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();

		linhas.forEach(n -> {
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("NU_LINHA", n.getLinha());
			source.addValue("NU_RAIZ_CNPJ", n.getRaizCnpj());
			params.add(source);
		});

		jdbc.batchUpdate(SQL_PERSISTE_LINHA, params.toArray(MapSqlParameterSource[]::new));
	}

	// Término da importação do arquivo em: 168 segundos
	public void persistirLinhas1(List<ArquivoMei> linhas) {
		try (PreparedStatement statement = jdbcTemplate.getDataSource().getConnection()
				.prepareStatement(SQL_PREPARED_PERSISTE_LINHA);) {

			linhas.forEach(n -> {
				try {
					statement.setLong(1, n.getLinha());
					statement.setString(2, n.getRaizCnpj());
					statement.addBatch();
				} catch (SQLException e) {
				}
			});

			statement.executeBatch();
		} catch (SQLException e) {
		}
	}
}
