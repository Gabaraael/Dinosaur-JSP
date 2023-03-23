package br.edu.ifms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}
	
	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	private void inserirNovoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException  {
		String sql = "INSERT INTO usuario (nome, cpf, data_nascimento, email, password, login, ativo)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";	

		//		Connection onePunchConnection = Conexao.getConexao();
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String dataNascimento = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		String ativo = request.getParameter("ativo");	
		
		conectar();
		
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1,nome);
		statement.setString(2, cpf);
		String dataNumero = dataNascimento;		
		ManipulacaoData manipulacaoData = new ManipulacaoData();
		Date data = manipulacaoData.convertStringToDate(dataNumero);		
		statement.setDate(3, data);
		statement.setString(4, email);
		statement.setString(5, password);
		statement.setString(6, login);
		statement.setBoolean(7, ativo);
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();
		
		//
		
//		statement.setString(1, usuario.getNome());
//		statement.setString(2, usuario.getCpf());
//		long dataNumero = usuario.getDataNascimento().getTime(); 
//		Date nascimento = new Date(dataNumero);
//		statement.setDate(3, nascimento);
//		statement.setString(4, usuario.getEmail());
//		statement.setString(5, usuario.getPassword());
//		statement.setString(6, usuario.getLogin());
//		statement.setBoolean(7, usuario.isAtivo());
		
//		usuario.setId(id);
//		return usuario;
//				
	
		
//		Usuario usuario = new Usuario(nome, cpf, dataNascimento, email, password, login, ativo);
		
		
		
		
		if (onePunchConnection != null) {
			System.out.println("Capturei uma inserir connection, meu primeiro pokennection");
		} else {

		}
	}

}