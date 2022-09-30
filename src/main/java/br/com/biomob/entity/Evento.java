package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "biomob_plus_evento")
public class Evento {

	@Id
	@Column(name = "evento_id")
	private String eventoId; //id do emprego
	
	@Column(name = "nome")
	private String nome; //Nome da função
	
	@Column(name = "local")
	private String local; //Local do trabalho
	
	@Column(name = "site")
	private String empresa; //Nome da empresa
	
	@Column(name = "descricao")
	private String descricao; //descrição da vaga

	@Column(name = "horario")
	private String horario; //Horario de trabalho

	@Column(columnDefinition="TEXT" ,name = "foto")
	private String foto;
	
}
