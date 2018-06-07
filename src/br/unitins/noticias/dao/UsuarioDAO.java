package br.unitins.noticias.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unitins.noticias.application.Util;
import br.unitins.noticias.factory.ConnectionFactory;
import br.unitins.noticias.factory.UsuarioFactory;
import br.unitins.noticias.model.Usuario;

public class UsuarioDAO implements DAO<Usuario>{

	private static final long serialVersionUID = -3626448937357882780L;
	
	public Usuario verificaLogin(String usuario, String senha) {
		return null;
	}

	@Override
	public boolean create(Usuario obj) {
		Connection conn = ConnectionFactory.getInstance();
		boolean retorno = false;
		try {
			PreparedStatement stat = 
					conn.prepareStatement("INSERT INTO Usuario ("
							+ "nome, "
							+ "login, "
							+ "dataNascimento"
							+ ") "
							+ "	VALUES (?, ?, ?) ");
			stat.setString(1, obj.getNome());
			stat.setString(2, obj.getLogin());
			stat.setDate(3,  obj.getDataNascimento() == null ? null: new Date(obj.getDataNascimento().getTime()) );
			
			stat.execute();
			retorno = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	@Override
	public boolean update(Usuario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Usuario obj) {
		Connection conn = ConnectionFactory.getInstance();
		boolean retorno = false;
		try {
			PreparedStatement stat = 
					conn.prepareStatement("DELETE FROM Usuario WHERE id = ?");
			stat.setInt(1, obj.getId());
			
			stat.execute();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return retorno;
	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getALL() {
		Connection conn = ConnectionFactory.getInstance();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement stat = 
					conn.prepareStatement("SELECT "
										+ "  id, nome, login "
										+ "FROM "
										+ "  Usuario");
			
			ResultSet rs =  stat.executeQuery();
			while (rs.next()) {
				Usuario u = UsuarioFactory.getInstance();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				
				listaUsuario.add(u);
			}
		} catch (SQLException e) {
			listaUsuario.clear();
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (listaUsuario.isEmpty())
			return null;
		return listaUsuario;

	}
	
}
