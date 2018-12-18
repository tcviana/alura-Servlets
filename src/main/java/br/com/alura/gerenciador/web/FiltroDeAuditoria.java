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

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		// validação do usuário por cookie
		String usuario = "Deslogado";
		Cookie ck = new Cookies(req.getCookies()).getUsuarioLogado();
		if (ck!=null) {
			usuario = ck.getValue();
		}
		
		usuario = "Deslogado";				
		// validação de usuário com session
		Usuario usr = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if (usr!=null) {
			usuario = usr.getEmail();
		}
		
				
		System.out.println("Usuário: <"+usuario+"> URI requisitada: "+req.getRequestURI());
		chain.doFilter(request,response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	
	}	

}
