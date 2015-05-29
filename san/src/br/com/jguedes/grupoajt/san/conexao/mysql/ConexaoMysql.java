/**
 * 
 */
package br.com.jguedes.grupoajt.san.conexao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author João Guedes 28/05/2015 19:56:40
 *
 */
public class ConexaoMysql {

	private Connection conn;

	private String nomebanco;
	private String senha;

	/**
	 * @param nomebanco
	 * @param senha
	 */
	public ConexaoMysql(String nomebanco, String senha) {

		this.setNomebanco(nomebanco);

		this.setSenha(senha);

	}

	/**
	 * @return the nomebanco
	 */
	public String getNomebanco() {
		return nomebanco;
	}

	/**
	 * @param nomebanco
	 *            the nomebanco to set
	 */
	public void setNomebanco(String nomebanco) {
		this.nomebanco = nomebanco;
	}

	/**
	 * @return
	 */
	public Connection create() {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ nomebanco, "root", senha);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}

		return conn;

	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
