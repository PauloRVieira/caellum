package br.com.caellum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caellum.jdbc.ConnectionFactory;
import br.com.caellum.jdbc.modelo.Contato;

public class ContatoDAO {

	// a conexão com o banco de dados
	private Connection connection;

	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos "
				+ "(nome, email, endereco, dataNascimento) "
				+ "values (?, ?, ?, ?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
 	}
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?,"
				+ " endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2,  contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public List<Contato> getLista() {
		return pesquisa("select * from contatos");
	}
	
	public Contato pesquisa(Contato contato) {
		String sql = "select * from contatos where nome = ? and email = ?"
				+ " and endereco = ? and dataNascimento = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				contato.setId(rs.getLong("id"));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
 		return contato;
	}
	
	public Contato pesquisa(int id) {
		Contato contato = null;
		
		List<Contato> lst = pesquisa("select * from contatos where id = " + id);
		if (lst.size() == 1) {
			contato = lst.get(0);
		} else if (lst.size() == 0) {
			throw new DAOException("Pesquisa não encontrou o registro");
		} else if (lst.size()  > 1) {
			throw new DAOException("Pesquisa encontrou mais de um registro para a pesquisa");
		}
		
 		return contato;
	}
	
	public List<Contato> pesquisa(String sql) {
		List<Contato> contatos = new ArrayList<Contato>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				// adicionando o objeto à lista
				contatos.add(contato);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
			
		return contatos;
 	}
	
}
