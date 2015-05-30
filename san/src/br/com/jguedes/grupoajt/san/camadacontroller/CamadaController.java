package br.com.jguedes.grupoajt.san.camadacontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jguedes.grupoajt.san.camadamodel.CamadaModel;
import br.com.jguedes.grupoajt.san.camadamodel.LayerModel;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.clientedenutricionista.ClienteDeNutricionista;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.nutricionista.Nutricionista;
import br.com.jguedes.grupoajt.san.camadaview.CamadaView;
import br.com.jguedes.grupoajt.san.camadaview.ILayerView;
import br.com.jguedes.grupoajt.san.conexao.BancoDeDados;
import br.com.jguedes.grupoajt.san.conexao.IBancoDeDados;

/**
 * 
 * Servlet implementation class CamadaController
 */
/**
 * @author João Guedes 28/05/2015 15:01:33
 *
 */
@WebServlet("/CamadaController")
public class CamadaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IBancoDeDados bancoDeDados = null;

	private LayerModel camadaModel = null;

	private ILayerView camadaView = null;

	/**
	 * Default constructor.
	 */
	public CamadaController() {
		System.out.println("Criando camda Controler.");
		bancoDeDados = new BancoDeDados();
		this.camadaModel = new CamadaModel(bancoDeDados);
		this.camadaView = new CamadaView();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String service = request.getParameter("service");

		if (service.equalsIgnoreCase("iniciar")) {

			response.getWriter().write(camadaView.getTelaDeLogin());

		} else if (service.equalsIgnoreCase("autenticarUser")) {

			System.out
					.println(request.getRemoteAddr() + ": solicitando login.");

			String email = request.getParameter("email");

			String senha = request.getParameter("senha");

			Usuario usuario = camadaModel.getUsuario(email, senha);

			if (usuario instanceof Nutricionista) {

				System.out.println(request.getRemoteAddr()
						+ ": login permitido (Nutricionista).");

				response.getWriter()
						.write(camadaView
								.getTelaPrincipalParaNutricionista(Nutricionista.class
										.cast(usuario)));

			} else if (usuario instanceof ClienteDeNutricionista) {

				System.out.println(request.getRemoteAddr()
						+ ": login permitido (Cliente de Nutricionista).");

				response.getWriter()
						.write(camadaView
								.getTelaPrincipalParaClienteDeNutricionista(ClienteDeNutricionista.class
										.cast(usuario)));

			} else {

				System.out.println(request.getRemoteAddr()
						+ ": login não permitido.");

				response.getWriter().write(
						camadaView.getTelaParaUsuarioNaoAutenticavel(usuario));

			}

		} else if (service.equalsIgnoreCase("armazenarfoto")) {

			System.out.println(request.getAttribute("foto"));

			String foto = request.getAttribute("foto").toString();

			response.getWriter().write(foto);

		}

	}
}