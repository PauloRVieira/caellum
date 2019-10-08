package br.com.caellum.jdbc.teste.funcionario;

import br.com.caellum.jdbc.dao.FuncionarioDAO;
import br.com.caellum.jdbc.modelo.Funcionario;

public class TestaPesquisa {

	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.pesquisa(1);
		
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Usuário: " + funcionario.getUsuario());
		System.out.println("Senha: " + funcionario.getSenha());
	}

}
