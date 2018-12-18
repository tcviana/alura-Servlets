package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {
	
	
	public BuscaEmpresa () {
		System.out.println("Instâncinciou uma servlet do tipo BuscaEmpresa "+this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Iniciou a servlet "+this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruiu a servlet "+this);
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // removida rotina abaixo para utilizar redirecionamento
    	/*
    	PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Resultado da busca:<br/>");
        writer.println("<ul>");
        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(req.getParameter("filtro"));
        for (Empresa empresa : empresas) {
			writer.println("<li>Codigo: "+empresa.getId()+" - Nome: "+empresa.getNome()+"</li>");
		}
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
        */
    	Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(req.getParameter("filtro"));
    	RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/pages/buscaEmpresa.jsp");
    	req.setAttribute("empresas", empresas);
    	disp.forward(req, resp);
    	

    }

}
