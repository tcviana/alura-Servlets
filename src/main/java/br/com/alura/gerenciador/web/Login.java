package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(req.getParameter("email"), req.getParameter("senha"));
	
		PrintWriter writer = resp.getWriter();
		if (usuario==null) {
			writer.println("<html><body>Usuário não encontrado.</body></html>");
		}else {
			// criação de cookie
			Cookie ck = new Cookie("usuario.logado", usuario.getEmail());
			ck.setMaxAge(10*60); // 60 segundos para manter o cookie
			//resp.addCookie(ck);// removida rotina de gravar cookie para utilizar a session
			// criação de session
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			//
			writer.println("<html><body>Usuário: "+ck.getValue()+" conectado!");						
		}
	}
}
