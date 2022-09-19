package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "biomob_plus_user")
public class User {

	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@Column(name = "deficiencia")
	private String deficiencia;
	
	@Column(columnDefinition="TEXT" ,name = "foto")
	private String foto;
	
	@Column(name = "password")
	private String password;

}
