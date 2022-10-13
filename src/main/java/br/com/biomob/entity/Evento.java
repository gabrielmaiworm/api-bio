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
	private String eventoId; 
	
	@Column(name = "nome")
	private String nome; 
	
	@Column(name = "local")
	private String local; 
	
	@Column(name = "site")
	private String site; 
	
	@Column(name = "descricao")
	private String descricao; 

	@Column(name = "horario_inicio")
	private String horarioInicio; 
	
	@Column(name = "horario_fim")
	private String horarioFim; 
	
	@Column(name = "data")
	private String data; 

	@Column(columnDefinition="TEXT" ,name = "foto")
	private String foto;
	
}
