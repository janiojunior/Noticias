package br.unitins.noticias.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.noticias.model.Estado;
import br.unitins.noticias.model.Usuario;


@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -6277287755375081111L;

	private Usuario usuario;
	private List<Usuario> listaUsuario;

	public String salvar() {
		// se o usuario nao exite na lista
		if (!getListaUsuario().contains(getUsuario())) {
			getListaUsuario().add(getUsuario());
		} else {
			// se ele existe na lista
			int posicao = getListaUsuario().indexOf(getUsuario());
			getListaUsuario().set(posicao, getUsuario());
		}

		setUsuario(null);
//		FacesContext.getCurrentInstance().addMessage(" ",new FacesMessage("Erro ao salvar"));
//		if (true)
//			return "cadastroUsuraio.xhtml";
		return "";

		
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
//			try {
//				using (SqlConnection con = ConexaoBD.GetInstancia.GetConnection()) {
//				try {
//			  		con.Open();
//					string sql = ("Select nome, idade from clientes where nome = '" + nome + "'");
//					SqlCommand cmd = new SqlCommand(sql, con);
//					SqlDataAdapter da = new SqlDataAdapter(cmd);
//					DataTable cliente = new DataTable();
//					da.Fill(cliente);
//					return cliente;
//				} catch (SqlException ex) {
//					throw ex;
//				} finally {
//				    con.Close();
//				}
//				}
//				} catch (Exception ex) {
//				    throw ex;
//				}
//			
//			listaUsuario = new ArrayList<Usuario>();
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