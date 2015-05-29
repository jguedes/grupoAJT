/**
 * 
 */
package br.com.jguedes.grupoajt.san.camadaview;

import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.clientedenutricionista.ClienteDeNutricionista;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.nutricionista.Nutricionista;

/**
 * @author João Guedes 28/05/2015 15:07:17
 *
 */
public class CamadaView implements ILayerView {

	/**
	 * 
	 */
	public CamadaView() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.jguedes.grupoajt.sistauxinutr.camadaview.ILayerView#getTelaDeLogin
	 * ()
	 */
	@Override
	public String getTelaDeLogin() {

		return "login.jsp";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.jguedes.grupoajt.san.camadaview.ILayerView#
	 * getTelaPrincipalParaClienteDeNutricionista
	 * (br.com.jguedes.grupoajt.san.camadamodel
	 * .usuario.clientedenutricionista.ClienteDeNutricionista)
	 */
	@Override
	public String getTelaPrincipalParaClienteDeNutricionista(
			ClienteDeNutricionista clienteDeNutricionista) {
		// TODO Auto-generated method stub
		return "clinutr.jsp";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.jguedes.grupoajt.san.camadaview.ILayerView#
	 * getTelaPrincipalParaNutricionista
	 * (br.com.jguedes.grupoajt.san.camadamodel.
	 * usuario.nutricionista.Nutricionista)
	 */
	@Override
	public String getTelaPrincipalParaNutricionista(Nutricionista nutricionista) {
		// TODO Auto-generated method stub
		return "nutr.jsp";
	}

	/* (non-Javadoc)
	 * @see br.com.jguedes.grupoajt.san.camadaview.ILayerView#getTelaParaUsuarioNaoAutenticavel(br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario)
	 */
	@Override
	public String getTelaParaUsuarioNaoAutenticavel(Usuario usuario) {
		// TODO Auto-generated method stub
		return "errautenticar.jsp";
	}

}
