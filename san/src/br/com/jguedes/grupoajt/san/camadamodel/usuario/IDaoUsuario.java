/**
 * 
 */
package br.com.jguedes.grupoajt.san.camadamodel.usuario;

/**
 * @author João Guedes 28/05/2015 20:27:33
 *
 */
public interface IDaoUsuario {

	/**
	 * @param email
	 * @param senha
	 * @return
	 */
	Usuario getUsuario(String email, String senha);

	
	
}
