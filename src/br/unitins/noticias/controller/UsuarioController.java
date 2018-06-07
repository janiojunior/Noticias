package br.unitins.noticias.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.noticias.application.Util;
import br.unitins.noticias.dao.UsuarioDAO;
import br.unitins.noticias.factory.ConnectionFactory;
import br.unitins.noticias.factory.UsuarioFactory;
import br.unitins.noticias.model.Estado;
import br.unitins.noticias.model.Usuario;


@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -6277287755375081111L;

	private Usuario usuario;
	private List<Usuario> listaUsuario;
	
	public void incluir() {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.create(getUsuario())) {
				Util.addInfoMessage("Inclusao realizada com sucesso!");
				limpar();
			} else		
				Util.addInfoMessage("Erro ao incluir!");
	}
	
	public void alterar() {
	}
	
	public void excluir() {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.delete(getUsuario())) {
				Util.addInfoMessage("Exclusão realizada com sucesso!");
				limpar();
			} else
				Util.addInfoMessage("Erro ao excluir!");
	}

	public void limpar() {
		usuario = null;
		listaUsuario = null;
	}

	public Usuario getUsuario() {
		if (usuario == null) 
			usuario = UsuarioFactory.getInstance();
		return usuario;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> lista = dao.getALL();
			if (lista == null) {
				Util.addErrorMessage("Erro ao buscar os dados do usuario.");
				listaUsuario = new ArrayList<Usuario>();
			} else 
				listaUsuario = lista;
		}
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}