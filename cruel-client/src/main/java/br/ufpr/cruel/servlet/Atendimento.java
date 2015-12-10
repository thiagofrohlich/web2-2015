package br.ufpr.cruel.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
	
	private List<br.ufpr.cruel.model.Atendimento> ListaAtendimento = new ArrayList<>();
	 
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
			
			if(request.getParameter("id") != null){
				atendimento.setId(Integer.parseInt(request.getParameter("id")));
			}
			Client client = ClientBuilder.newClient();
			String cliente = request.getParameter("cliente");
			String split[] = cliente.split("-"); 
			
			TipoCliente tipoCliente = client.target("http://localhost:8080/cruel-ws/TipoCliente/"+split[0])
					.request(MediaType.APPLICATION_JSON)
					.get(TipoCliente.class);
			
			atendimento.setData(Calendar.getInstance().getTime());
			atendimento.setTipoCliente(tipoCliente);
			atendimento.setValor(tipoCliente.getValorRefeicao());
			
			if(atendimento.getId() != null){
				client.target("http://localhost:8080/cruel-ws/Atendimento")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(atendimento), br.ufpr.cruel.model.TipoCliente.class);
			}else{
				client.target("http://localhost:8080/cruel-ws/Atendimento")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(atendimento), br.ufpr.cruel.model.TipoCliente.class);
			}
			
			ListaAtendimento =  (List<br.ufpr.cruel.model.Atendimento>) client.target("http://localhost:8080/cruel-ws/Atendimento")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaAtendimento", ListaAtendimento);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/registrarAtendimento.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("edit")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			br.ufpr.cruel.model.Atendimento atendimento = client.target("http://localhost:8080/cruel-ws/Atendimento/"+id)
			.request(MediaType.APPLICATION_JSON)
			.get(br.ufpr.cruel.model.Atendimento.class);
			
			request.setAttribute("atendimento", atendimento);
			ListaAtendimento =  (List<br.ufpr.cruel.model.Atendimento>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaCliente", ListaAtendimento);
			
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
			
			ListaAtendimento =  (List<br.ufpr.cruel.model.Atendimento>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaAtendimento", ListaAtendimento);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/registrarAtendimento.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("inicio")){
			Client client = ClientBuilder.newClient();
			ListaAtendimento =  (List<br.ufpr.cruel.model.Atendimento>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaCliente", ListaAtendimento);
			
			ListaAtendimento =  (List<br.ufpr.cruel.model.Atendimento>) client.target("http://localhost:8080/cruel-ws/Atendimento")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaAtendimento", ListaAtendimento);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/registrarAtendimento.jsp");
			rd.forward(request, response);
		}
		
	}

}
