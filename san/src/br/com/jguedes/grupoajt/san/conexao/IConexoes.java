/**
 * 
 */
package br.com.jguedes.grupoajt.san.conexao;

import java.sql.Connection;

/**
 * @author João Guedes 28/05/2015 19:51:25
 *
 */
public interface IConexoes {

	public Connection getConexaoMysql();
	
	public Connection getConexaoPostgresql();
	
	public Connection getConexaoDerby();

	/**
	 * @param conn
	 */
	public void fecharConexao(Connection conn);
	
}
