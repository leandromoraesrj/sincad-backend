package com.github.leandromoraesrj.sincadbackend.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private static final Integer maxQuantidadeLinhaLidas = 1000000;

	@Autowired
	private ArquivoMeiRepository repo;

	private void importarArquivoMei() {
		try {
			logger.info(MessageFormat.format("Lendo arquivo: {0}", Paths.get(PATH_ARQUIVO_MEI).toAbsolutePath()));

			List<String> list = Files.readAllLines(Paths.get(PATH_ARQUIVO_MEI), StandardCharsets.UTF_8);

			if (list.size() == 0)
				throw new Exception("Arquivo vázio");

			List<ArquivoMei> linhas = new ArrayList<ArquivoMei>();
			Integer linha;

			for (linha = 1; linha <= list.size(); linha++) {
				String raizCnpj = list.get(linha - 1).substring(0, 8);
				linhas.add(new ArquivoMei(Long.valueOf(linha), raizCnpj));

				if (linhas.size() >= maxQuantidadeLinhaLidas) {
					repo.persistirLinhas(linhas);

					logger.info(MessageFormat.format("Número de linhas lidas: {0}", linha));

					linhas.clear();
				}
			}

			if (linhas.size() < maxQuantidadeLinhaLidas) {
				repo.persistirLinhas(linhas);

				logger.info(MessageFormat.format("Número de linhas lidas: {0}", linha));

				linhas.clear();
			}
		} catch (StringIndexOutOfBoundsException e) {
			logger.error(MessageFormat.format("Tamanho inválido da linha: {0}", e.getMessage()));
		} catch (IOException e) {
			logger.error("Arquivo não encontrado");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void iniciarImportacaoArquivoMei() {
		Date inicio = new Date();
		logger.info("Iniciando importação do arquivo");
		importarArquivoMei();
		logger.info(MessageFormat.format("Término da importação do arquivo em: {0} segundos",
				((new Date().getTime() - inicio.getTime())) / 1000));
	}
}