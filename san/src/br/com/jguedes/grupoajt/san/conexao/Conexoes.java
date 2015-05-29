/**
 * 
 */
package br.com.jguedes.grupoajt.san.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.jguedes.grupoajt.san.conexao.mysql.ConexaoMysql;

/**
 * @author João Guedes 28/05/2015 19:53:38
 *
 */
public class Conexoes implements IConexoes {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.jguedes.grupoajt.san.conexao.IConexoes#getConexaoMysql()
	 */
	@Override
	public Connection getConexaoMysql() {

		System.out.println("Criando conexão");
		
		return new ConexaoMysql("san", "123456").create();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.jguedes.grupoajt.san.conexao.IConexoes#getConexaoPostgresql()
	 */
	@Override
	public Connection getConexaoPostgresql() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.jguedes.grupoajt.san.conexao.IConexoes#getConexaoDerby()
	 */
	@Override
	public Connection getConexaoDerby() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.jguedes.grupoajt.san.conexao.IConexoes#fecharConexao(java.sql.
	 * Connection)
	 */
	@Override
	public void fecharConexao(Connection conn) {

		System.out.println("Fechando conexão");
		
		if (conn != null)

			try {

				if (!conn.isClosed())
					conn.close();

			} catch (SQLException e) {

				e.printStackTrace();

			}

	}

}
