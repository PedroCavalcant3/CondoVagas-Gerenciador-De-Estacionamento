package br.com.condovagas.controle.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.condovagas.controle.models.VagaModel;
import br.com.condovagas.controle.repository.VagaRepository;



@Component
public class DummyData {
	final VagaRepository vagaRepository;

	public DummyData(VagaRepository vagaRepository) {
		this.vagaRepository = vagaRepository;
	}
	//@PostConstruct
	public void savePosts() {

		List<VagaModel> vagaList = new ArrayList<>();
		VagaModel vaga = new VagaModel();
		vaga.setNumeroDaVaga("1");
		vaga.setPlacaDoVeiculo("AAA0000");
		vaga.setMarcaDoCarro("Audi");
		vaga.setModeloDoCarro("q5");
		vaga.setCorDoCarro("preto");
		vaga.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		vaga.setDataAtualizacao((LocalDateTime.now(ZoneId.of("UTC"))));
		vaga.setNomeDoResponsavel("João Pedro");
		vaga.setUrlImagem("https://zh.rbsdirect.com.br/imagesrc/23461233.jpg?w=700");
		vaga.setNumeroDoApartamento("13");
		vaga.setBloco('B');

		VagaModel vaga2 = new VagaModel();
		vaga2.setNumeroDaVaga("2");
		vaga2.setPlacaDoVeiculo("BBB0000");
		vaga2.setMarcaDoCarro("Hyundai");
		vaga2.setModeloDoCarro("HB20");
		vaga2.setCorDoCarro("preto");
		vaga2.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		vaga2.setDataAtualizacao((LocalDateTime.now(ZoneId.of("UTC"))));
		vaga2.setNomeDoResponsavel("Larissa Souza");
		vaga2.setUrlImagem("https://conteudo.imguol.com.br/c/noticias/9b/2020/08/12/rg-digital-ja-pode-ser-baixado-no-estado-de-sao-paulo-1597251715799_v2_900x506.png.webp");
		vaga2.setNumeroDoApartamento("15");
		vaga2.setBloco('A');

		vagaList.add(vaga);
		vagaList.add(vaga2);

		for (VagaModel vagas : vagaList) {
			VagaModel vagaSalva = vagaRepository.save(vagas);
			System.out.println(vagaSalva.getId());
		}
	}
}
