package br.com.condovagas.controle.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
@Data
public class FormVagaDto {
	@NotBlank(message = "Insira apenas números, não pode estar vazio")
	private String numeroDaVaga;
	
	@NotBlank(message = "uma placa contem 7 carácteres, não pode estar vazio")
	@Size(max = 7)
	private String placaDoVeiculo;
	
	@NotBlank
	private String marcaDoCarro;
	
	@NotBlank
	private String modeloDoCarro;
	
	@NotBlank(message = "")
	private String corDoCarro;
	
	@NotBlank(message = "")
	private String nomeDoResponsavel;
	
	@NotBlank(message = "insira apenas números, não pode estar vazio")
	private String numeroDoApartamento;
	
	@NotNull(message = "insira apenas 1 carácter")
	private Character bloco;
	
	@NotBlank(message = "ex: https://br.web.img3.acsta.net/c_310_420/pictures/18/09/12/19/42/5521101.jpg")
	private String urlImagem;
	


}
