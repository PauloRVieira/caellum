package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caellum.jdbc.dao.ContatoDAO;
import br.com.caellum.jdbc.modelo.Contato;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaContatoServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// busca o writer
    	PrintWriter out = resp.getWriter();
    	
    	// buscando os parametros no request
    	String nome = req.getParameter("nome");
    	String endereco = req.getParameter("endereco");
    	String email = req.getParameter("email");
    	String dataNascimentoTxt = req.getParameter("dataNascimento");
    	Calendar dataNascimento = Calendar.getInstance();
    	
    	// fazendo a conversão de data
    	try {
			dataNascimento.setTime( new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTxt) );
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			e.printStackTrace();
			return;
		}
    	
    	// monta o objeto contato
    	Contato contato = new Contato();
    	contato.setNome(nome);
    	contato.setEndereco(endereco);
    	contato.setEmail(email);
    	contato.setDataNascimento(dataNascimento);
    	
    	// salva o contato
    	ContatoDAO dao = new ContatoDAO();
    	dao.adiciona(contato);
    	
    	// imprime o nome do contato que foi adicionado
    	out.println("<html>");
    	out.println("<body>");
    	out.println("Contato " + nome + " adicionado com sucesso");
    	out.println("</body>");
    	out.println("</html>");
    }
}
