package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// armazena valor do parametro
		String tarefa = req.getParameter("tarefa");
		if (tarefa==null)
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		try {
			// preenche o caminho/nome da classe
			String nomeDaClasse = "br.com.alura.gerenciador.web."+tarefa;
			// função para declarar uma classe baseada em seu nome como string
			Class<?> type = Class.forName(nomeDaClasse);
			// sabendo o tipo da classe, instancia o objeto
			Tarefa instancia = (Tarefa) type.newInstance();
			// página de retorno da instancia, por exemplo: mandar para logout.jsp
			String pagina = instancia.executa(req, resp);
			// redireciona conforme endereço da pagina acima
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
