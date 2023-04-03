package br.com.condovagas.controle.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Table(name = "VAGA_ESTACIONAMENTO")
@Data
public class VagaModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true, length = 10)
	private String numeroDaVaga;

	@Column(nullable = false, unique = true, length = 7)
	private String placaDoVeiculo;

	@Column(nullable = false, length = 20)
	private String marcaDoCarro;

	@Column(nullable = false, length = 20)
	private String modeloDoCarro;

	@Column(nullable = false, length = 15)
	private String corDoCarro;

	@Column(nullable = false)
	private LocalDateTime dataDeRegistro;
	
	@Column(nullable = false)
	private LocalDateTime dataAtualizacao;

	@Column(nullable = false, length = 130)
	private String nomeDoResponsavel;
	
	 @Column(nullable = false)
	    private String urlImagem;

	@Column(nullable = false, length = 5)
	private String numeroDoApartamento;

	@Column(nullable = false)
	private char bloco;

}
