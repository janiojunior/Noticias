package br.unitins.noticias.model;

import java.io.Serializable;

public class Noticia implements Serializable {
	private static final long serialVersionUID = 8785146520605971597L;
	
	private Integer id;
	private String titulo;
	private String subtitulo;
	private String resumo;
	private String texto;
}
