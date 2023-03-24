package br.edu.ifms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import br.edu.ifms.dao.util.Conexao;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.util.ManipulacaoData;

public class UsuarioDAO {
	
	private Connection connection;
	
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
	
	public Usuario insertUser(Usuario user) throws SQLException {
		
		conectar();
		
		String sql = "INSERT INTO usuario (nome, cpf, data_nascimento, email, password, login, ativo)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";	

		
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1,user.getNome());
		statement.setString(2, user.getCpf());			
		Long data = user.getDataNascimento().getTime();		
		Date dataNascimento = new Date(data);
		statement.setDate(3, dataNascimento);
		statement.setString(4, user.getEmail());
		statement.setString(5, user.getPassword());
		statement.setString(6, user.getLogin());
		statement.setBoolean(7, user.isAtivo());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();
		
		user.setId(id);
		desconectar();
		
		return user;		
	}
	
	
	
	

}
