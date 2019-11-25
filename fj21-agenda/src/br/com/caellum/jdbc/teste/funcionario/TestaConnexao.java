package br.com.caellum.jdbc.teste.funcionario;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caellum.jdbc.ConnectionFactory;

public class TestaConnexao {
	
	public static void main(String... args) throws SQLException {
		Connection conexao = new ConnectionFactory().getConnection();
		System.out.println("Conex�o aberta!");
		conexao.close();
	}
	
}
