package br.com.biomob.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import lombok.Data;

	@Data
	@Entity
	@Table(name = "biomob_plus_admin")
	public class Admin {

		@Id
		@Column(name = "email")
		private String email;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "cpf")
		private String cpf;
		
		@Column(name = "telefone")
		private String telefone;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "nivel")
		private Integer nivel;
		
		@Column(name = "token")
		private String token;

	}

