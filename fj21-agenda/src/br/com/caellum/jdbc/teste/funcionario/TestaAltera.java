package br.com.caellum.jdbc.teste.funcionario;

import br.com.caellum.jdbc.dao.FuncionarioDAO;
import br.com.caellum.jdbc.modelo.Funcionario;

public class TestaAltera {

	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Paulo");
		funcionario.setSenha("teste123");
		funcionario.setUsuario("paulus");
		
		dao.adiciona(funcionario);
		
		// adiciona o ID (melhorar)
		dao.pesquisa(funcionario);
		
		funcionario.setNome("Paulo Funcionario");
		funcionario.setSenha("teste321");
		funcionario.setUsuario("paulusrv");
		dao.altera(funcionario);
		
		dao.remove(funcionario);
	}

}
