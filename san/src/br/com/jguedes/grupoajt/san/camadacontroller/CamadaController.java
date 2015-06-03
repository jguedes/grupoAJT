package br.com.jguedes.grupoajt.san.camadacontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import br.com.jguedes.grupoajt.san.camadamodel.CamadaModel;
import br.com.jguedes.grupoajt.san.camadamodel.LayerModel;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.Usuario;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.clientedenutricionista.ClienteDeNutricionista;
import br.com.jguedes.grupoajt.san.camadamodel.usuario.nutricionista.Nutricionista;
import br.com.jguedes.grupoajt.san.camadaview.CamadaView;
import br.com.jguedes.grupoajt.san.camadaview.ILayerView;
import br.com.jguedes.grupoajt.san.conexao.BancoDeDados;
import br.com.jguedes.grupoajt.san.conexao.IBancoDeDados;
import br.com.jguedes.grupoajt.san.conexao.arquivo.ManipuladorDeImagemEmDiretorio;

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

		String foto = request.getParameter("foto").toString();

		System.out.println(foto);

		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		IOUtils.copy(pegandoImagemNoDisco(foto), out);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String service;

		if (ServletFileUpload.isMultipartContent(request)) {

			manipularDadosComArquivos(request, response);

			return;

		}

		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");

		if ((service = request.getParameter("service")) == null) {

			response.getWriter().write("Falta o serviço.");

		} else if (service.equalsIgnoreCase("iniciar")) {

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

		}

	}

	/**
	 * @param request
	 * @param response
	 */
	private void manipularDadosComArquivos(HttpServletRequest request,
			HttpServletResponse response) {

		try {

			FileItemIterator itens = ServletFileUpload.class.newInstance()
					.getItemIterator(request);

			while (itens.hasNext()) {

				FileItemStream item = itens.next();

				if (item.isFormField()) {

					// service = item.getFieldName();
					//
					// System.out.println("service: " + service);

				} else {

					// service = item.getFieldName();

					InputStream foto = item.openStream();

					String extensao = "jpg";
					String diretorio = "/mnt/774ce448-05a2-4fc5-a56c-3261efee833f/Desenvolvimento/GitHub/Repositorios/grupoAJT/san/WebContent/images";
					String nomeDaImagem = request.getLocalAddr()
							.replace(".", "_").concat("_refeicao_")
							.concat(String.valueOf(System.currentTimeMillis()));

					ManipuladorDeImagemEmDiretorio m = new ManipuladorDeImagemEmDiretorio(
							foto, extensao, diretorio, nomeDaImagem);

					m.gravar();

					// long i = System.currentTimeMillis() + 5000;
					//
					// while (System.currentTimeMillis() < i)
					// ;

					// response.setContentType("image/jpeg");

					// String[] split = request.getRequestURL().toString()
					// .split("CamadaController");

					String queryString = "CamadaController?foto="
							.concat(nomeDaImagem).concat(".").concat(extensao);

					// String src = split[0].concat("images").concat("/")
					// .concat(nomeDaImagem).concat(".").concat(extensao);

					// System.out.println(src);

					response.getWriter().write(queryString);

					// ImageIO.write(m.getImagem(), extensao,
					// response.getOutputStream());
					// // response.getOutputStream().write(m.getEmBinario());
					// response.getOutputStream().flush();
					// response.getOutputStream().close();

				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static InputStream pegandoImagemNoDisco(String imagemName) {

		try {
			return new FileInputStream(
					new File(
							"/mnt/774ce448-05a2-4fc5-a56c-3261efee833f/Desenvolvimento/GitHub/Repositorios/grupoAJT/san/WebContent/images/"
									.concat(imagemName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private static byte[] _pegandoImagemNoDisco(String imagemName) {

		File file = new File("WebContent/images/".concat(imagemName));

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ManipuladorDeImagemEmDiretorio.getDataFromInputStream(fis);

	}
}