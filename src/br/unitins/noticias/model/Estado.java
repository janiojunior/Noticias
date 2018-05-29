package br.unitins.noticias.model;

import java.io.Serializable;

public class Estado implements Serializable {
	private static final long serialVersionUID = -2613889976237833204L;
	
	private String nome;
	private String sigla;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}