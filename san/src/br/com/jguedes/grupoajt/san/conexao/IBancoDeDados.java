package br.com.jguedes.grupoajt.san.conexao;

import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;

/**
 * @author João Guedes 28/05/2015 15:00:22
 *
 */
public interface IBancoDeDados {

	public static final IConexoes CONEXOES = new Conexoes();
	
	/**
	 * @param email
	 * @param senha
	 * @return
	 */
	public Usuario getUsuario(String email, String senha);

}
