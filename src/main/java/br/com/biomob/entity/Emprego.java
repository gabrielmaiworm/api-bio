package br.com.biomob.entity;

import java.util.Date;

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
	
	@Column(name = "local")
	private String local; //Local do trabalho
	
	@Column(name = "cargo")
	private String cargo; //Cargo a ser exercido
	
	@Column(name = "salario")
	private String salario; //Salário
	
	@Column(name = "empresa")
	private String empresa; 
	
	@Column(name = "descricao")
	private String descricao; 
	
	@Column(name = "link")
	private String link; 
	
	@Column(name = "data_exclusao")
	private Date dataExclusao; 
	
	@Column(columnDefinition="TEXT" ,name = "logo")
	private String logo;
	
	@Column(name = "tipo")  // Remoto, hibrido, presencial
	private String tipo; 
		
}
