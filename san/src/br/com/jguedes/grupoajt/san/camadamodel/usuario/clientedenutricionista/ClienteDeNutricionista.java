/**
 * 
 */
package br.com.jguedes.grupoajt.san.camadamodel.usuario.clientedenutricionista;

import br.com.jguedes.grupoajt.san.camadamodel.programadenutricao.ProgramaDeNutricao;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;

/**
 * @author João Guedes 28/05/2015 17:52:25
 *
 */
public class ClienteDeNutricionista extends Usuario {

	private ProgramaDeNutricao programaDeNutricao;

	/**
	 * @param nome
	 * @param email
	 */
	public ClienteDeNutricionista(String nome, String email) {
		super(nome, email);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the programaDeNutricao
	 */
	public ProgramaDeNutricao getProgramaDeNutricao() {
		return programaDeNutricao;
	}

	/**
	 * @param programaDeNutricao
	 *            the programaDeNutricao to set
	 */
	public void setProgramaDeNutricao(ProgramaDeNutricao programaDeNutricao) {
		this.programaDeNutricao = programaDeNutricao;
	}

}
