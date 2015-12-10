package br.ufpr.cruel.servlet;

import java.io.IOException;
import java.math.BigDecimal;
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

/**
 * Servlet implementation class TipoCliente
 */
public class TipoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<TipoCliente> listaCliente = new ArrayList<>();
    public TipoCliente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("salva")){
			br.ufpr.cruel.model.TipoCliente tipoCliente = new br.ufpr.cruel.model.TipoCliente();
			tipoCliente.setDescricao(request.getParameter("descricao"));
			tipoCliente.setValorRefeicao(new BigDecimal(request.getParameter("valor")));
			
			if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
				tipoCliente.setId(Integer.parseInt(request.getParameter("id")));
			}
			
			Client client = ClientBuilder.newClient();
			
			if(tipoCliente.getId() != null){
				client.target("http://localhost:8080/cruel-ws/TipoCliente")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(tipoCliente),br.ufpr.cruel.model.TipoCliente.class);
			}else{
				client.target("http://localhost:8080/cruel-ws/TipoCliente")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(tipoCliente),br.ufpr.cruel.model.TipoCliente.class);
			}
			
			
			listaCliente =  (List<TipoCliente>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			
			request.setAttribute("listaCliente", listaCliente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/tipoCliente.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("edit")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			br.ufpr.cruel.model.TipoCliente tipoCliente = client.target("http://localhost:8080/cruel-ws/TipoCliente/"+id)
			.request(MediaType.APPLICATION_JSON)
			.get(br.ufpr.cruel.model.TipoCliente.class);
			
			request.setAttribute("tipoCliente", tipoCliente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/tipoCliente.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("delete")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			client.target("http://localhost:8080/cruel-ws/TipoCliente/"+id)
			.request(MediaType.APPLICATION_JSON)
			.delete(Pessoa.class);
			
			listaCliente =  (List<TipoCliente>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaCliente", listaCliente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/tipoCliente.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("inicio")){
			Client client = ClientBuilder.newClient();
			listaCliente =  (List<TipoCliente>) client.target("http://localhost:8080/cruel-ws/TipoCliente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaCliente", listaCliente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/tipoCliente.jsp");
			rd.forward(request, response);
		}
	}

}
