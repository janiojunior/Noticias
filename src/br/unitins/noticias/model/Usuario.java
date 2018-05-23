package br.unitins.noticias.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;


public class Usuario implements Serializable {
	private static final long serialVersionUID = -6656347778647534535L;

	@NotEmpty(message=" O nome não pode ser nulo ou vazio.")
	private String nome;
	
	@NotEmpty(message=" O login não pode ser nulo ou vazio.")
	private String login;
	
	private String senha;
	
	private Date dataNascimento;
	
	private Boolean ativo;
	
	private String cpf;
	
	private String email;
	
	private Float altura;

	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}