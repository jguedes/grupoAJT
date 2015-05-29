/**
 * 
 */
package br.com.jguedes.grupoajt.san.camadamodel.usuario;

/**
 * @author João Guedes 28/05/2015 17:23:13
 *
 */
public abstract class Usuario {

	private int id;
	private String nome;
	private String email;
	private String codigoDeAcesso;

	/**
	 * 
	 */
	public Usuario(String nome, String email) {
		this.email = email;
		this.nome = nome;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the codigoDeAcesso
	 */
	public String getCodigoDeAcesso() {
		return codigoDeAcesso;
	}

	/**
	 * @param codigoDeAcesso
	 *            the codigoDeAcesso to set
	 */
	public void setCodigoDeAcesso(String codigoDeAcesso) {
		this.codigoDeAcesso = codigoDeAcesso;
	}

}
