package com.github.leandromoraesrj.sincadbackend.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.leandromoraesrj.sincadbackend.domain.ArquivoMei;
import com.github.leandromoraesrj.sincadbackend.repositories.ArquivoMeiRepository;

@Service
public class ArquivoMeiService {
	private static Logger logger = LoggerFactory.getLogger(ArquivoMeiService.class);
	private static final String PATH_ARQUIVO_MEI = "arquivo/PERMEI.txt";
	private static final int maxQuantidadeLinhaLidas = 1000000;

	@Autowired
	private ArquivoMeiRepository repo;

	private void importarArquivoMei() {
		logger.info(MessageFormat.format("Lendo arquivo: {0}", Paths.get(PATH_ARQUIVO_MEI).toAbsolutePath()));

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_ARQUIVO_MEI), StandardCharsets.UTF_8)) {
			List<ArquivoMei> linhas = new ArrayList<ArquivoMei>();
			long qtdLinha = 0L;
			Optional<String> linha;

			while ((linha = Optional.ofNullable(reader.readLine())).isPresent()) {
				String raizCnpj = linha.get().substring(0, 8);
				qtdLinha++;

				linhas.add(new ArquivoMei(qtdLinha, raizCnpj));

				if (linhas.size() % maxQuantidadeLinhaLidas == 0) {
					logger.info(MessageFormat.format("Quantidade de linhas lidas: {0}", qtdLinha));
					logger.info("Executando Batch");
					repo.executeBatch(linhas, ArquivoMeiRepository.TIPO_BATCH_NAMED);
					linhas.clear();
				}
			}

			if (linhas.size() % maxQuantidadeLinhaLidas != 0) {
				logger.info(MessageFormat.format("Quantidade de linhas lidas: {0}", qtdLinha));
				logger.info("Executando Batch");
				repo.executeBatch(linhas);
			}
		} catch (StringIndexOutOfBoundsException e) {
			logger.error(MessageFormat.format("Tamanho inv??lido da linha: {0}", e.getMessage()));
		} catch (IOException e) {
			logger.error("Arquivo n??o encontrado");
		} catch (RuntimeException e) {
			logger.error(MessageFormat.format("Erro ao executar o Batch: {0}", e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void iniciarImportacaoArquivoMei() {
		Date inicio = new Date();
		logger.info("Iniciando importa????o do arquivo");
		importarArquivoMei();
		logger.info(MessageFormat.format("T??rmino da importa????o do arquivo em: {0} segundos",
				((new Date().getTime() - inicio.getTime())) / 1000));
	}
}