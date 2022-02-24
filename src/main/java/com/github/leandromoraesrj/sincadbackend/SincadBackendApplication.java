package com.github.leandromoraesrj.sincadbackend;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.leandromoraesrj.sincadbackend.domain.DacInclusaoRegimeApuracao;
import com.github.leandromoraesrj.sincadbackend.domain.Estabelecimento;
import com.github.leandromoraesrj.sincadbackend.domain.EstabelecimentoPrincipal;
import com.github.leandromoraesrj.sincadbackend.domain.Inscricao;
import com.github.leandromoraesrj.sincadbackend.domain.RegimeApuracao;
import com.github.leandromoraesrj.sincadbackend.domain.TipoUnidadeEstabelecimento;
import com.github.leandromoraesrj.sincadbackend.domain.UnidadeEmpresarial;
import com.github.leandromoraesrj.sincadbackend.domain.enuns.TipoPessoaEnum;
import com.github.leandromoraesrj.sincadbackend.repositories.DacInclusaoRegimeApuracaoRepository;
import com.github.leandromoraesrj.sincadbackend.services.ArquivoMeiService;
import com.github.leandromoraesrj.sincadbackend.services.EstabelecimentoService;
import com.github.leandromoraesrj.sincadbackend.services.RegimeApuracaoService;
import com.github.leandromoraesrj.sincadbackend.services.UnidadeEmpresarialService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SincadBackendApplication implements CommandLineRunner {
	@Value("${spring.profiles.active}")
	private String applicationProfile;

	// Para testar o servico
	@Autowired
	private RegimeApuracaoService regimeService;

	@Autowired
	private UnidadeEmpresarialService unidadeService;

	@Autowired
	private EstabelecimentoService estabService;

	@Autowired
	private ArquivoMeiService arquivoMeiService;

	// Para testar repositório
	@Autowired
	private DacInclusaoRegimeApuracaoRepository dacRegimeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SincadBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (applicationProfile.equals("test")) {
			RegimeApuracao regime1 = new RegimeApuracao();
			regime1.setCodigo(3);
			regime1.setInicio(LocalDate.now());
			regime1.setNome("SIMEI");

			RegimeApuracao regime2 = new RegimeApuracao();
			regime2.setCodigo(99);
			regime2.setInicio(LocalDate.now());
			regime2.setNome("PERMEI");

			regimeService.salvarTodos(Arrays.asList(regime1, regime2));

			regime2.setNome("MEI");
			regimeService.salvarTodos(Arrays.asList(regime2));

//			regimeService.delete(regime1.getId());

			log.info(regimeService.listarTodos().toString());
			log.info(regimeService.obter(1).toString());
			log.info(regimeService.existe(1).toString());
			log.info(regimeService.existe(0).toString());
			log.info(regimeService.obterPorCodigo(1).toString());
			log.info(regimeService.consultarPorNome("simples").toString());
			log.info(regimeService.consultarPorNomeOuCodigo("simples", 3).toString());
			log.info(regimeService.consultarPorCodigos(Arrays.asList(1, 2, 3)).toString());
			log.info(regimeService.consultarPorIds(Arrays.asList(1, 2, 3)).toString());

			log.info(regimeService.consultarPorNomeOuCodigoVigente("Me", 1).toString());

			log.info(regimeService.consultarPorNomeVigente("Me").toString());

//			regimeService.deletePorNome("normal");
//			regimeService.deletePorNome("simples nacional");			
//		
//			regimeService.deleteTodos();

			log.info(regimeService.listarTodos().toString());

			UnidadeEmpresarial unidade1 = new UnidadeEmpresarial();
			unidade1.setCpf("08097980770");
			unidade1.setRazaoSocial("Leandro");
			unidade1.setTipoPessoa(TipoPessoaEnum.PESSOA_FISICA);
			unidade1.setHistoricoRazaoSocial(Arrays.asList("Leandro O. de Moraes", "Leandro O. M."));

			TipoUnidadeEstabelecimento tipoUnidade = new TipoUnidadeEstabelecimento();
			tipoUnidade.setId(1);

			Estabelecimento estab1 = new Estabelecimento();
			estab1.setUnidadeEmpresarial(unidade1);
			estab1.setCnpj("12345678901234");
			estab1.setTitulo("LO de Tecnologia");
			estab1.setTiposUnidadeEstabelecimento(new HashSet<TipoUnidadeEstabelecimento>(Arrays.asList(tipoUnidade)));

			Estabelecimento estab2 = new Estabelecimento();
			estab2.setUnidadeEmpresarial(unidade1);
			estab2.setCnpj("12345678923523");
			estab2.setTitulo("LO Sítio");
			estab2.setTiposUnidadeEstabelecimento(new HashSet<TipoUnidadeEstabelecimento>(Arrays.asList(tipoUnidade)));

			unidade1.setEstabelecimentos(Arrays.asList(estab1, estab2));

			Inscricao inscricao1 = new Inscricao();
			inscricao1.setNumero(32124);
			inscricao1.setDataConcessao(LocalDate.now());

			estab1.setInscricao(inscricao1);
			inscricao1.setEstabelecimento(estab1);

			unidadeService.adicionarEmpresa(unidade1);
			estabService.adicionarEstabelecimento(estab1);
			estabService.adicionarEstabelecimento(estab2);

			DacInclusaoRegimeApuracao dac = new DacInclusaoRegimeApuracao();

			dac.setDataCriacao(LocalDateTime.now());
			dac.setDataProcessamento(Instant.now());
			dac.setEstabelecimento(estab1);
			dac.setInicio(LocalDate.of(2022, Month.FEBRUARY, 19));
			dac.setNumero("1234134");
			dac.setUnidadeEmpresarial(unidade1);
			dac.setEstabelecimento(estab1);
			dac.setRegimeApuracao(regime1);

			dacRegimeRepository.save(dac);
			
			log.info(dac.getInicio().toString());
//			EstabelecimentoPrincipal teste = new EstabelecimentoPrincipal();
//			arquivoMeiService.iniciarImportacaoArquivoMei();
		}
	}
}