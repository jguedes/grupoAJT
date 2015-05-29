/**
 * 
 */
package br.com.jguedes.grupoajt.san.camadamodel.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jguedes.grupoajt.san.camadamodel.usuario.clientedenutricionista.ClienteDeNutricionista;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.nutricionista.Nutricionista;

/**
 * @author João Guedes 28/05/2015 20:41:39
 *
 */
public class DaoUsuario implements IDaoUsuario {

	private Connection conn;

	/**
	 * @param conn
	 */
	public DaoUsuario(Connection conn) {

		this.conn = conn;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.jguedes.grupoajt.san.camadamodel.usuario.IDaoUsuario#getUsuario
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario getUsuario(String email, String senha) {

		Usuario usuario = null;

		PreparedStatement ps = null;

		ResultSet rs = null;

		String sql = "select nome, isNutr from usuario where email = ? and senha = MD5(?)";

		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			ps.setString(2, senha);

			rs = ps.executeQuery();

			while (rs.next()) {

				if (rs.getInt("isNutr") != 0) {

					usuario = new Nutricionista(rs.getString("nome"), email);

				} else if (rs.getInt("isNutr") == 0) {

					usuario = new ClienteDeNutricionista(rs.getString("nome"),
							email);

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

}
