package br.edu.ifms.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.dao.util.Conexao;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/publica")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "novo":
				novoUsuario(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	private void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection onePunchConnection = Conexao.getConexao();
		if (onePunchConnection != null) {
			System.out.println("Capturei uma connection, meu primeiro pokennection");
		} else {

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publicacaoUsuario.jsp");
		dispatcher.forward(request, response);
	}

}
