/**
 * 
 */
package br.com.jguedes.grupoajt.san.camadamodel.usuario.nutricionista;

import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;

/**
 * @author João Guedes 28/05/2015 17:44:30
 *
 */
public class Nutricionista extends Usuario {

	private String crn;

	/**
	 * @param nome
	 * @param email
	 */
	public Nutricionista(String nome, String email) {
		super(nome, email);

	}

	/**
	 * @return the crn
	 */
	public String getCrn() {
		return crn;
	}

	/**
	 * @param crn
	 *            the crn to set
	 */
	public void setCrn(String crn) {
		this.crn = crn;
	}

}
