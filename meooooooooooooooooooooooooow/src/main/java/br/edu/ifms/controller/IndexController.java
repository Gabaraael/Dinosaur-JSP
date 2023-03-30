package br.edu.ifms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.dao.UsuarioDAO;
import br.edu.ifms.dao.util.Conexao;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.util.ManipulacaoData;

@WebServlet("/publica")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processaRequisicao(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		try {
			switch (acao) {
			case "novo":
				chamarPageNovoUsuario(request, response);
				break;
				case "inserir":					
					inserirNovoUsuario(request, response);
					break;				
				}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}	

	private void chamarPageNovoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection onePunchConnection = Conexao.getConexao();
		
		if (onePunchConnection != null) {
			System.out.println("Capturei uma connection, meu primeiro pokennection");
		} else {
			System.out.println("Falhei meu primeiro pokennection");				
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publicacaoUsuario.jsp");
		dispatcher.forward(request, response);
	}	
	
	private void inserirNovoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException  {		
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String dataNascimentoString = request.getParameter("nascimento");
		Date dataNascimento = ManipulacaoData.convertStringToDate(dataNascimentoString);	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		
		Usuario usuario = new Usuario(nome, cpf, dataNascimento, email, password, login, true);
		System.out.println(request.getParameter("nascimento"));
				
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario user =  userDao.insertUser(usuario);
		
//		chamarPageNovoUsuario(request, response);
	}
}