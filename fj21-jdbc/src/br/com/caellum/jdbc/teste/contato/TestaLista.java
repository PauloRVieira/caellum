package br.com.caellum.jdbc.teste.contato;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caellum.jdbc.dao.ContatoDAO;
import br.com.caellum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()) + "\n");
		}
	}

}
