package br.com.caellum.jdbc.teste.contato;

import java.text.SimpleDateFormat;

import br.com.caellum.jdbc.dao.ContatoDAO;
import br.com.caellum.jdbc.modelo.Contato;

public class TestaPesquisa {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		Contato contato = dao.pesquisa(1);
		
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereço: " + contato.getEndereco());
		System.out.println("Data de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()) + "\n");
	}

}
