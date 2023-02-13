package br.com.biomob.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "biomob_plus_calcada")
public class Calcada {
	
	@Id
	@Column(name = "calcada_id")
	private String calcadaId; //id da calcada
	
	@Column(name = "cep")
	private String cep;

	@Column(name = "estado")
	private String estado;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "comprimento")
	private double comprimento;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "lati")
	private double lati;
	
	@Column(name = "latf")
	private double latf;
	
	@Column(name = "lngf")
	private double lngf;
	
	@Column(name = "lngi")
	private double lngi;
	
	@Column(name = "lat")
	private double lat;
	
	@Column(name = "lng")
	private double lng;
	
	@Column(name = "observacao_endereco")
	private String observacao_endereco;
	
	@Column(name = "observacao_calçada")
	private String observacao_calçada;
	
	@Column(name = "largura_calcada")
	private double largura_calcada;
	
	@Column(name = "faixa_calcada")
	private String faixa_calcada;
	
	@Column(name = "pavimentacao_calcada")
	private String pavimentacao_calcada;
		
	@Column(name = "obstaculos_calcada")
	private String obstaculos_calcada;
	
	@Column(name = "pisos_rampas")
	private String pisos_rampas;
	
	@Column(name = "inclinacao")
	private String inclinacao;
	
	@Column(name = "tipo_travessia")
	private String tipo_travessia;
	
	@Column(name = "acessivel")
	private boolean acessivel ;
	
	@Column(name = "foto_calcada")
	private String foto_calcada;

	@Column(name = "foto_pavimentacao")
	private String foto_pavimentacao;

	@Column(name = "foto_piso_direcional")
	private String foto_piso_direcional;

	@Column(name = "foto_piso_alerta")
	private String foto_piso_alerta;
	
	@Column(name = "foto_obstaculo")
	private String foto_obstaculo;
	
	@Column(name = "foto_tipos_travessia")
	private String foto_tipos_travessia;
	
	@Column(name = "foto_faixa")
	private String foto_faixa;
	
	@Column(name = "foto_piso_rampa")
	private String foto_piso_rampa;
	
	@Column(name = "nota")
	private int nota;
	
	
}
