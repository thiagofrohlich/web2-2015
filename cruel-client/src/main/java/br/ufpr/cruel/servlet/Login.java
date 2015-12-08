package br.ufpr.cruel.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import br.ufpr.cruel.model.Pessoa;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message;
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		if(email == null || senha == null || "".equals(email.trim()) || "".equals(senha.trim())) {
			message = "Todos os campos devem ser preenchidos!";
			forwardToErrorPage(req, resp, message);
		} 
		
		Client client = ClientBuilder.newClient();
		Pessoa usuario = client.target("http://localhost:8080/cruel-ws/Pessoa/usuario?email="+ email +"&senha="+ senha)
				.request(MediaType.APPLICATION_JSON)
				.get(Pessoa.class);
		
		if(usuario == null) {
			message = "Combinação de e-mail e senha não encontrado!";
			forwardToErrorPage(req, resp, message);
		}
		
		Cookie cUsuario = new Cookie("usuario", usuario.getEmail());
		Cookie cUsuarioId = new Cookie("usuarioId", ""+usuario.getId());
		Cookie cTipoUsuario = new Cookie("usuario", usuario.getTipoPessoa());
		
		cUsuario.setMaxAge(1800);
		cUsuarioId.setMaxAge(1800);
		cTipoUsuario.setMaxAge(1800);
		
		resp.addCookie(cUsuario);
		resp.addCookie(cUsuarioId);
		resp.addCookie(cTipoUsuario);
		
		getServletContext().getRequestDispatcher("/pages/inicialCliente.jsp").forward(req, resp);
	}

	private void forwardToErrorPage(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/errorPage.jsp");
		req.setAttribute("message", message);
		resp.setCharacterEncoding("utf-8");
		dispatcher.forward(req, resp);
	}

}
