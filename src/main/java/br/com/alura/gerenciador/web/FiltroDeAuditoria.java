package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String usuario = "Deslogado";
		Cookie ck = getUsuario(req);
		if (ck!=null) {
			usuario = ck.getValue();
		}
				
		System.out.println("Usuário: <"+usuario+"> URI requisitada: "+req.getRequestURI());
		chain.doFilter(request,response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	
	}
	
	private Cookie getUsuario(HttpServletRequest req) {
		Cookie[] ck = req.getCookies();
		if (ck==null) {
			return null;
		}
		for (Cookie cookie : ck) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}
		return null;
	}

}
