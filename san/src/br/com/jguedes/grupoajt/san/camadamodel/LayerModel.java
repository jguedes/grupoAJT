package br.com.jguedes.grupoajt.san.camadamodel;

import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;
import br.com.jguedes.grupoajt.san.conexao.IBancoDeDados;

/**
 * @author João Guedes 28/05/2015 15:00:07
 *
 */
public abstract class LayerModel {

	private IBancoDeDados bancoDeDados = null;

	public LayerModel(IBancoDeDados bancoDeDados) {

		this.bancoDeDados = bancoDeDados;

	}

	/**
	 * @param email
	 * @param senha
	 * @return um objeto do tipo Usuario
	 */
	public Usuario getUsuario(String email, String senha) {

		return bancoDeDados.getUsuario(email, senha);

	}

}
