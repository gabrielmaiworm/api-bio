package br.com.biomob.entity;

import java.util.ArrayList;

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

	@Column(name = "observacao_endereco")
	private String observacaoEndereco;
	
	@Column(name = "largura_calcada")
	private double larguraCalcada;
	
	@Column(name = "faixa_calcada")
	private ArrayList<String> faixa;
	
	@Column(name = "pavimentacao_calcada")
	private ArrayList<String> pavimentacao;
	
	@Column(name = "sinalizacao_tatil_calcada")
	private ArrayList<String> sinalizacaoTatil;
	
	@Column(name = "obstaculos_calcada")
	private ArrayList<String> obstaculos;
	
	@Column(name = "extra_calcada")
	private ArrayList<String> extra;
	
	@Column(name = "geral_travessia")
	private ArrayList<String> geralTravessia;

	@Column(name = "tipo_ilha_refugio_travessia")
	private ArrayList<String> tipoIlhaRefugioTravessia;

	@Column(name = "ilha_refugio_travessia")
	private ArrayList<String> ilhaRefugioTravessia;
	
	@Column(name = "tipo_travessia")
	private ArrayList<String> tipoTravessia;

	@Column(name = "foto_pavimentacao")
	private String fotoPavimentacao;

	@Column(name = "foto_piso_direcional")
	private String fotoPisoDirecional;

	@Column(name = "foto_piso_alerta")
	private String fotoPisoAlerta;
	
	@Column(name = "foto_obstaculo")
	private String fotoObstaculo;
	
	@Column(name = "foto_extra_calcada")
	private String fotoExtraCalcada;
	
	@Column(name = "foto_travessia_geral")
	private String fotoTravessiaGeral;
	
	@Column(name = "foto_ilha_refugio")
	private String fotoIlhaRefugio;
	
	@Column(name = "foto_tipos_travessia")
	private String fotoTiposTravessia;
	
	@Column(name = "nota")
	private int nota;
	
	
	
}
