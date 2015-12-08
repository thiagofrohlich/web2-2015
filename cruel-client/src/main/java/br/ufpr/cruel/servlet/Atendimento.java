package br.ufpr.cruel.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import br.ufpr.cruel.model.Pessoa;
import br.ufpr.cruel.model.TipoCliente;

/**
 * Servlet implementation class Atendimento
 */
public class Atendimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private List<Pessoa> ListaAtendimento = new ArrayList<>();
	 
    public Atendimento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("salva")){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			br.ufpr.cruel.model.Atendimento atendimento = new br.ufpr.cruel.model.Atendimento();
			
			Client client = ClientBuilder.newClient();

			TipoCliente tipoCliente = client.target("http://localhost:8080/cruel-ws/TipoCliente/descricao"+request.getParameter("descricao"))
					.request(MediaType.APPLICATION_JSON)
					.get(TipoCliente.class);
			
			try {
				atendimento.setData(sdf.parse(request.getParameter("data")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			atendimento.setTipoCliente(tipoCliente);
			atendimento.setValor(tipoCliente.getValorRefeicao());
			
			client.target("http://localhost:8080/cruel-ws/TipoCliente")
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.json(tipoCliente), br.ufpr.cruel.model.TipoCliente.class);
			
			ListaAtendimento =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaTipoCliente", ListaAtendimento);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/registrarAtendimento.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("edit")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			br.ufpr.cruel.model.Atendimento atendimento = client.target("http://localhost:8080/cruel-ws/Pessoa/"+id)
			.request(MediaType.APPLICATION_JSON)
			.get(br.ufpr.cruel.model.Atendimento.class);
			
			request.setAttribute("pessoa", atendimento);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/registrarAtendimento.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("delete")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			client.target("http://localhost:8080/cruel-ws/Pessoa/"+id)
			.request(MediaType.APPLICATION_JSON)
			.delete(br.ufpr.cruel.model.Atendimento.class);
			
			ListaAtendimento =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaTipoCliente", ListaAtendimento);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/registrarAtendimento.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("inicio")){
			Client client = ClientBuilder.newClient();
			ListaAtendimento =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaTipoCliente", ListaAtendimento);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/registrarAtendimento.jsp");
			rd.forward(request, response);
		}
		
	}

}
