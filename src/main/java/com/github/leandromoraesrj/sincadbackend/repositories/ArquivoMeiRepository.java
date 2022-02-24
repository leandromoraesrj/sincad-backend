package com.github.leandromoraesrj.sincadbackend.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.leandromoraesrj.sincadbackend.domain.ArquivoMei;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ArquivoMeiRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcNamed;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final int TIPO_BATCH_NAMED = 1;
	public static final int TIPO_BATCH_STATEMENT = 2;

	private static final String SQL_INSERT_NAMED = "INSERT INTO ARQUIVO_MEI (NU_LINHA, NU_RAIZ_CNPJ) VALUES (:NU_LINHA,:NU_RAIZ_CNPJ)";
	private static final String SQL_INSERT = "INSERT INTO ARQUIVO_MEI (NU_LINHA, NU_RAIZ_CNPJ) VALUES (?,?)";

	public void executeBatch(List<ArquivoMei> list, int tipoBatch) {
		if (tipoBatch == TIPO_BATCH_NAMED)
			executeBatchNamed(list);
		else if (tipoBatch == TIPO_BATCH_STATEMENT)
			executeBatchStatement(list);
	}

	public void executeBatch(List<ArquivoMei> list) {
		executeBatchNamed(list);
	}

	private void executeBatchNamed(List<ArquivoMei> list) {
		List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();

		list.forEach(n -> {
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("NU_LINHA", n.getLinha());
			source.addValue("NU_RAIZ_CNPJ", n.getRaizCnpj());
			params.add(source);
		});

		log.debug(MessageFormat.format("Batch Named executing for: {0}", list.size()));
		jdbcNamed.batchUpdate(SQL_INSERT_NAMED, params.stream().toArray(MapSqlParameterSource[]::new));
		log.debug("Batch Named executed");
	}

	private void executeBatchStatement(List<ArquivoMei> list) {
		try (PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT)) {
			log.debug("Connection established");

			list.forEach(n -> {
				try {
					statement.setLong(1, n.getLinha());
					statement.setString(2, n.getRaizCnpj());
					statement.addBatch();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			});

			log.debug(MessageFormat.format("Batch Statement executing for: {0}", list.size()));
			statement.executeBatch();
			log.debug("Batch Statement executed");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}