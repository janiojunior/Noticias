package br.unitins.noticias.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -1269890694712678672L;

	public String logar() {
		return "usuario.xhtml";
	}

}