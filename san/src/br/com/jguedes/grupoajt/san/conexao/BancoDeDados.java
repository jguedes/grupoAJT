package br.com.jguedes.grupoajt.san.conexao;

import java.sql.Connection;

import br.com.jguedes.grupoajt.san.camadamodel.usuario.DaoUsuario;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.IDaoUsuario;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;

/**
 * @author João Guedes 28/05/2015 15:02:06
 *
 */
public class BancoDeDados implements IBancoDeDados {

	private Connection conn;
	private IDaoUsuario daoUsuario = null;

	public BancoDeDados() {


	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.jguedes.grupoajt.san.conexao.IBancoDeDados#getUsuario(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public Usuario getUsuario(String email, String senha) {

		conn = CONEXOES.getConexaoMysql();
		
		daoUsuario = new DaoUsuario(conn);

		Usuario usuario = daoUsuario.getUsuario(email, senha);

		CONEXOES.fecharConexao(conn);

		return usuario;

	}

}
