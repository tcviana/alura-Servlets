package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// remove session
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		return "/WEB-INF/pages/logout.html";
	} 
}
// inibida versão antiga com servet dedicado para usar servlet geral
/*
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// remove cookie
		Cookie ck = new Cookies(req.getCookies()).getUsuarioLogado();
		if (ck!=null) {
			ck.setMaxAge(0);
			resp.addCookie(ck);
		}
		// remove session
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		
		// redirecionamento de resposta, não consegue acessar o diretório web-inf
		//resp.sendRedirect("/WEB-INF/pages/logout.html");
		
		// redirecionamento pelo servidor
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/pages/logout.html");		
		disp.forward(req, resp);
	}
}
*/