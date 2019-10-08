package br.com.caellum.jdbc.teste.contato;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.caellum.jdbc.dao.ContatoDAO;
import br.com.caellum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Paulo");
		contato.setEmail("paulorvieira@yahoo.com.br");
		contato.setEndereco("São Paulo SP");
		contato.setDataNascimento(Calendar.getInstance());
		
		dao.adiciona(contato);
		
		// adiciona o ID (melhorar)
		dao.pesquisa(contato);
		
		contato.setNome("Paulo R Vieira");
		contato.setEmail("paulusrv@gmail.com");
		contato.setEndereco("São Roque");
		dao.altera(contato);
		
		dao.remove(contato);
	}

}
