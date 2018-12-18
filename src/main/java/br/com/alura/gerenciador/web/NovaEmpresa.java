package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// método para add empresa
		Empresa empresa = new Empresa(req.getParameter("nome"));
		new EmpresaDAO().adiciona(empresa);
		
		//adiciona empresa na requisição
		req.setAttribute("empresa", empresa);
		// página de retorno
		return "/WEB-INF/pages/novaEmpresa.jsp";
		
	}
}
// inibida rotina de servlet dedicado para usar o geral
/*
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Empresa empresa = new Empresa(req.getParameter("nome"));
		new EmpresaDAO().adiciona(empresa);
		
		RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/pages/novaEmpresa.jsp");
		req.setAttribute("empresa", empresa);
		disp.forward(req, resp);
	}

}
*/