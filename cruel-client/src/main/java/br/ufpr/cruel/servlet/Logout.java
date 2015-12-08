package br.ufpr.cruel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		for(Cookie cookie : req.getCookies()) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		
		getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
		
	}
	
}
