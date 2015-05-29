package br.com.jguedes.grupoajt.san.camadaview;

import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.clientedenutricionista.ClienteDeNutricionista;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.nutricionista.Nutricionista;

/**
 * @author João Guedes 28/05/2015 14:59:28
 *
 */
public interface ILayerView {

	/**
	 * @return a url da tela de login
	 */
	public String getTelaDeLogin();

	/**
	 * @param usuario
	 * @return
	 */
	public String getTelaPrincipalParaClienteDeNutricionista(
			ClienteDeNutricionista clienteDeNutricionista);

	/**
	 * @param usuario
	 * @return
	 */
	public String getTelaPrincipalParaNutricionista(Nutricionista nutricionista);

	/**
	 * @param usuario
	 * @return
	 */
	public String getTelaParaUsuarioNaoAutenticavel(Usuario usuario);

}
