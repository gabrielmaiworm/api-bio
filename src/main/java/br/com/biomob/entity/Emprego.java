package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "biomob_plus_emprego")
public class Emprego {

	@Id
	@Column(name = "emprego_id")
	private String empregoId; //id do emprego
	
	@Column(name = "nome")
	private String nome; //Nome da função
	
	@Column(name = "local")
	private String local; //Local do trabalho
	
	@Column(name = "cargo")
	private String cargo; //Cargo a ser exercido
	
	@Column(name = "salario")
	private String salario; //Salário
	
	@Column(name = "empresa")
	private String empresa; //Nome da empresa
	
	@Column(name = "descricao")
	private String descricao; //descrição da vaga
	
	@Column(name = "beneficios")
	private String beneficios; //Beneficios dados
	
	@Column(name = "horarios")
	private String horarios; //Horario de trabalho
	
	@Column(name = "regime_contratacao")
	private String regimeContratacao; //Regime de contratação - CLT,PJ
		
}
