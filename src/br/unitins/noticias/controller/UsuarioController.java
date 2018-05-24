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
import br.unitins.noticias.model.Estado;
import br.unitins.noticias.model.Usuario;


@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -6277287755375081111L;

	private Usuario usuario;
	private List<Usuario> listaUsuario;
	
	private Connection getConnection() {
		Connection conn = null;
		try {			  
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/noticiadb?"
							+ "useSSL=false", "noticia", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}

	public void incluir() {
		Connection conn = getConnection();
		try {
			PreparedStatement stat = 
					conn.prepareStatement("INSERT INTO Usuario (nome, login, dataNascimento) "
							+ "	VALUES (?, ?, ?) ");
			stat.setString(1, getUsuario().getNome());
			stat.setString(2, getUsuario().getLogin());
//			Date data = null;
//			if (getUsuario().getDataNascimento() == null)
//				data = new Date(getUsuario().getDataNascimento().getTime());
			
			stat.setDate(3,  getUsuario().getDataNascimento() == null ? null: new Date(getUsuario().getDataNascimento().getTime()) );
			
			
			stat.execute();
			
			Util.addInfoMessage("Inclusao realizada com sucesso!");
			
			listaUsuario = null;
			
		} catch (SQLException e) {
			Util.addInfoMessage("Erro ao incluir!");
			e.printStackTrace();
		}
				
		
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
			usuario.setEstado(new Estado());
		}
		return usuario;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			Connection conn = getConnection();
			listaUsuario = new ArrayList<Usuario>();
			try {
				PreparedStatement stat = 
						conn.prepareStatement("SELECT "
											+ "  id, nome, login "
											+ "FROM "
											+ "  Usuario");
				
				ResultSet rs =  stat.executeQuery();
				while (rs.next()) {
					Usuario u = new Usuario();
					u.setId(rs.getInt("id"));
					u.setNome(rs.getString("nome"));
					u.setLogin(rs.getString("login"));
					listaUsuario.add(u);
				}
			} catch (SQLException e) {
				Util.addErrorMessage("Erro ao buscar os dados do usuario.");
				e.printStackTrace();
			}
			
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