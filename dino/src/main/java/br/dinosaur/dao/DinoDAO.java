package br.dinosaur.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.dinosaur.dao.util.Conexao;
import br.dinosaur.model.Dinosaur;

public class DinoDAO {
	
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
	
	public Dinosaur insertDino(Dinosaur dino) throws SQLException {
		String sql = "INSERT INTO Dinosauria (specie, diet, habitat, period, description)"
				+ " VALUES (?, ?, ?, ?, ?)";	
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);		
		statement.setString(1,dino.getSpecie());
		statement.setString(2, dino.getDiet());			
		statement.setString(3, dino.getHabitat());		
		statement.setString(4, dino.getPeriod());
		statement.setString(5, dino.getDescription());		
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		long id = 0;
		if(resultSet.next())			
			id = resultSet.getLong(1);
		statement.close();
		
		dino.setId(id);
		desconectar();
		
		return dino;		
	}
	
	
	
	

}
