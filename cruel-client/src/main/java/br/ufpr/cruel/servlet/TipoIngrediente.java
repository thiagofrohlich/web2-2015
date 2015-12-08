package br.ufpr.cruel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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


/**
 * Servlet implementation class TipoIngrediente
 */
public class TipoIngrediente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoIngrediente() {
        super();
    }
    private List<br.ufpr.cruel.model.TipoIngrediente> listatipoIngrediente = new ArrayList<>();

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
			br.ufpr.cruel.model.TipoIngrediente tipo = new br.ufpr.cruel.model.TipoIngrediente();
			tipo.setNome(request.getParameter("nome"));
			
			Client client = ClientBuilder.newClient();
			client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.json(tipo), br.ufpr.cruel.model.TipoIngrediente.class);
			
			listatipoIngrediente =  (List<br.ufpr.cruel.model.TipoIngrediente>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaTipoIngrediente", listatipoIngrediente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterTipoIngrediente.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("edit")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			br.ufpr.cruel.model.TipoIngrediente tipo = client.target("http://localhost:8080/cruel-ws/TipoIngrediente/"+id)
			.request(MediaType.APPLICATION_JSON)
			.get(br.ufpr.cruel.model.TipoIngrediente.class);
			
			request.setAttribute("ing", tipo);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterTipoIngrediente.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("delete")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			client.target("http://localhost:8080/cruel-ws/TipoIngrediente/"+id)
			.request(MediaType.APPLICATION_JSON)
			.delete(br.ufpr.cruel.model.TipoIngrediente.class);
			
			listatipoIngrediente =  (List<br.ufpr.cruel.model.TipoIngrediente>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaTipoIngrediente", listatipoIngrediente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterTipoIngrediente.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("inicio")){
			Client client = ClientBuilder.newClient();
			listatipoIngrediente =  (List<br.ufpr.cruel.model.TipoIngrediente>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaTipoIngrediente", listatipoIngrediente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterTipoIngrediente.jsp");
			rd.forward(request, response);
		}
	}

	public List<br.ufpr.cruel.model.TipoIngrediente> getListatipoIngrediente() {
		return listatipoIngrediente;
	}

	public void setListatipoIngrediente(List<br.ufpr.cruel.model.TipoIngrediente> listatipoIngrediente) {
		this.listatipoIngrediente = listatipoIngrediente;
	}

}
