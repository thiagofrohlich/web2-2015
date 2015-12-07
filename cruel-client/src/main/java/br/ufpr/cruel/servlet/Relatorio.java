package br.ufpr.cruel.servlet;

import java.io.IOException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.JasperViewer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Relatorio
 */

public class Relatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Relatorio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Connection con = null;
			try {
				// Conexão com o banco
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/web2",
						"postgres", "postgres");
				// Caminho físico do relatório compilado
				String jasper = request.getContextPath() +
						"/relMensal.jasper";
				// Host onde o servlet esta executando
				String host = "http://" + request.getServerName() +
						":" + request.getServerPort();
				// URL para acesso ao relatório
				URL jasperURL = new URL(host + jasper);
				HashMap params = new HashMap();
				byte[] bytes = JasperRunManager.runReportToPdf(
						jasperURL.openStream(), params, con);
				if (bytes != null) {
					// A página será mostrada em PDF
					response.setContentType("application/pdf");
					// Envia o PDF para o Cliente
					OutputStream ops = null;
					ops = response.getOutputStream();
					ops.write(bytes);
				}
			}
			catch(ClassNotFoundException e) {
				// erro de driver
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<html><head>");
				out.println("<title>Servlet GeradorRelatorio</title>");
				out.println("</head><body>");
				out.println("<h1>Erro de Driver (" + e.getMessage() +
						") no Servlet GeradorRelatorio at " +
						request.getContextPath () + "</h1>");
				out.println("</body></html>");
				out.flush();
			}
			catch(SQLException e) {
				// erro de SQL
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<html><head>");
				out.println("<title>Servlet GeradorRelatorio</title>");
				out.println("</head><body>");
				out.println("<h1>Erro de SQL (" + e.getMessage() +
						") no Servlet GeradorRelatorio at " +
						request.getContextPath () + "</h1>");
				out.println("</body></html>");
				out.flush();
			}
			catch(JRException e) {
				// erro de Jasper
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<html><head>");
				out.println("<title>Servlet GeradorRelatorio</title>");
				out.println("</head><body>");
				out.println("<h1>Erro de Jasper (" + e.getMessage() +
						") no Servlet GeradorRelatorio at " +
						request.getContextPath () + "</h1>");
				out.println("</body></html>");
				out.flush();
			}
			finally {
				if (con!=null)
					try { con.close(); } catch(Exception e) {}
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
