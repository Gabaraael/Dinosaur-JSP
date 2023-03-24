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

import br.edu.ifms.dao.util.Conexao;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.util.ManipulacaoData;

/**
 * Servlet implementation class IndexController
 */
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
				novoUsuario(request, response);
				break;
			case "inserir":
				inserirNovoUsuario(request, response);
				break;				
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
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
	
	private void inserirNovoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException  {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String dataNascimentoString = request.getParameter("dataNascimento");
		Date dataNascimento = ManipulacaoData.convertStringToDate(dataNascimentoString);	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
//		String ativo = request.getParameter("ativo");	
		
		Usuario usuario = new Usuario(nome, cpf, dataNascimento, email, password, login, true);
		
		
//		usuario.setId(id);
//		return usuario;
//				
	
		
//		Usuario usuario = new Usuario(nome, cpf, dataNascimento, email, password, login, ativo);
		
		
		
		
		if (connection != null) {
			System.out.println("Capturei uma inserir connection, meu primeiro pokennection");
		} else {

		}
	}

}