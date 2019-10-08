package br.com.caellum.jdbc.teste.funcionario;

import br.com.caellum.jdbc.dao.FuncionarioDAO;
import br.com.caellum.jdbc.modelo.Funcionario;

public class TestaInsere {

	public static void main(String[] args) {
		// pronto para gravar
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Guilherme Silveira Caelum");
		funcionario.setUsuario("contato@caelum.com.br");
		funcionario.setSenha("R3185cj57");
		
		// grave nessa conex�o!!!
		FuncionarioDAO dao = new FuncionarioDAO();
		
		// m�todo elegante
		dao.adiciona(funcionario);
		
		System.out.println("Gravado!");
	}

}
