package br.ufpr.cruel.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 * Servlet implementation class Relatorio
 */

public class Relatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Relatorio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("mensal")){
			Connection con = null;
			Integer mes = Integer.parseInt(request.getParameter("mes"));
			Integer ano = Integer.parseInt(request.getParameter("ano"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			String ini = "01"+mes+ano;
			String fim = montaData(mes)+mes+ano;
			Date dataini = null;
			Date datafim = null;
			try {
				dataini = dateFormat.parse(ini);
				datafim = dateFormat.parse(fim);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			try {
				// Conex�o com o banco
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/web2",
						"postgres", "postgres");
				// Caminho f�sico do relat�rio compilado
				String jasper = request.getContextPath() +
						"/pages/relMensal.jasper";
				// Host onde o servlet esta executando
				String host = "http://" + request.getServerName() +
						":" + request.getServerPort();
				// URL para acesso ao relat�rio
				URL jasperURL = new URL(host + jasper);
				HashMap params = new HashMap();
				params.put("mes", retornaMes(mes));
				params.put("ano", ano.toString());
				params.put("dataini", dataini);
				params.put("datafim", datafim);
				
				byte[] bytes = JasperRunManager.runReportToPdf(
						jasperURL.openStream(), params, con);
				if (bytes != null) {
					// A p�gina ser� mostrada em PDF
					response.setContentType("application/pdf");
					// Envia o PDF para o Cliente
					OutputStream ops = null;
					ops = response.getOutputStream();
					ops.write(bytes);
				}
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(JRException e) {
				e.printStackTrace();
			}
			finally {
				if (con!=null)
					try { con.close(); } catch(Exception e) {}
			}
		}
		
		if(action.equals("anual")){
			Connection con = null;
			Integer ano = Integer.parseInt(request.getParameter("ano"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			String ini = "01"+01+ano;
			String fim = "3112"+ano;
			Date dataini = null;
			Date datafim = null;
			try {
				dataini = dateFormat.parse(ini);
				datafim = dateFormat.parse(fim);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			try {
				// Conex�o com o banco
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/web2",
						"postgres", "postgres");
				// Caminho f�sico do relat�rio compilado
				String jasper = request.getContextPath() +
						"/pages/relAnual.jasper";
				// Host onde o servlet esta executando
				String host = "http://" + request.getServerName() +
						":" + request.getServerPort();
				// URL para acesso ao relat�rio
				URL jasperURL = new URL(host + jasper);
				HashMap params = new HashMap();
				params.put("ano", ano.toString());
				params.put("dataini", dataini);
				params.put("datafim", datafim);
				
				byte[] bytes = JasperRunManager.runReportToPdf(
						jasperURL.openStream(), params, con);
				if (bytes != null) {
					// A p�gina ser� mostrada em PDF
					response.setContentType("application/pdf");
					// Envia o PDF para o Cliente
					OutputStream ops = null;
					ops = response.getOutputStream();
					ops.write(bytes);
				}
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(JRException e) {
				e.printStackTrace();
			}
			finally {
				if (con!=null)
					try { con.close(); } catch(Exception e) {}
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String montaData(Integer mes){
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 6:
		case 8:
		case 10:
		case 12:
			return "31";
		case 2:
			return "28";

		default:
			return "30";
		}
	}
	
	private String retornaMes(Integer mes){
		switch (mes) {
		case 1: return "Janeiro";
		case 2: return "Fevereiro";
		case 3: return "Março";
		case 4: return "Abril";
		case 5: return "Maio";
		case 6: return "Junho";
		case 7: return "Julho";
		case 8: return "Agosto";
		case 9: return "Setembro";
		case 10: return "Outubro";
		case 11: return "Novembro";
		case 12: return "Desembro";
	}
		return null;
	}

}
