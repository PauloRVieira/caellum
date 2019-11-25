package br.com.caellum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caellum.jdbc.ConnectionFactory;
import br.com.caellum.jdbc.modelo.Funcionario;

public class FuncionarioDAO {
	
	private Connection connection;

	public FuncionarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Funcionario funcionario) {
		try {
			String sql = "insert into funcionarios"
					+ " (nome, usuario, senha)"
					+ " values (?, ?, ?)";
					
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Funcionario> getLista() {
		return pesquisa("select * from funcionarios");
	}
	
	public Funcionario pesquisa(Funcionario funcionario) {
		try {
			String sql = "select * from funcionarios";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				funcionario.setId(rs.getLong("id"));
			}
			
  			rs.close();
			stmt.close();
			
			return funcionario;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Funcionario pesquisa(int id) {
		Funcionario funcionario = null;
		
		List<Funcionario> lst = pesquisa("select * from funcionarios where id = " + id);
		if (lst.size() == 1) {
			funcionario = lst.get(0);
		} else if (lst.size() == 0) {
			throw new DAOException("Pesquisa não encontrou o registro");
		} else if (lst.size()  > 1) {
			throw new DAOException("Pesquisa encontrou mais de um registro para a pesquisa");
		}
		
 		return funcionario;
	}

	public List<Funcionario> pesquisa(String sql) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto funcionario
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				
				// adicionando o objeto à lista
				funcionarios.add(funcionario);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
			
		return funcionarios;
 	}
	
	public void altera(Funcionario funcionario) {
		try {
			String sql = "update funcionarios"
					+ " set nome = ?, usuario = ?, senha = ?";
					
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void remove(Funcionario funcionario) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from funcionarios where id = ?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
}
