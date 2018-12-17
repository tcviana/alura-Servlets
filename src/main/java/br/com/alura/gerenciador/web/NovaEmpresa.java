package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Empresa empresa = new Empresa(req.getParameter("nome"));
		new EmpresaDAO().adiciona(empresa);
		
		PrintWriter writter = resp.getWriter();		
		writter.println("<html><body>Empresa: "+empresa.getNome()+" cadastrada com sucesso.</body></html>");
	}

}