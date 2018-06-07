package br.unitins.noticias.factory;

import br.unitins.noticias.model.Estado;
import br.unitins.noticias.model.Usuario;

public class UsuarioFactory {
	
	private UsuarioFactory() {}
	
	public static Usuario getInstance() {
		Usuario usuario = new Usuario();
		usuario.setEstado(new Estado());
		return usuario;
	}

}
