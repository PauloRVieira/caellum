package br.com.caellum.jdbc.teste.funcionario;

import java.util.List;

import br.com.caellum.jdbc.dao.FuncionarioDAO;
import br.com.caellum.jdbc.modelo.Funcionario;

public class TestaLista {

	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.getLista();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Usuário: " + funcionario.getUsuario());
			System.out.println("Senha: " + funcionario.getSenha());
		}
	}

}
