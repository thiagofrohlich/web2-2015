package br.ufpr.cruel.servlet;

import java.io.IOException;
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

import br.ufpr.cruel.model.TipoIngrediente;

/**
 * Servlet implementation class Ingrediente
 */
public class Ingrediente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private List<br.ufpr.cruel.model.Ingrediente> listaIngrediente = new ArrayList<>();
    public Ingrediente() {
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
			br.ufpr.cruel.model.Ingrediente ingrediente= new br.ufpr.cruel.model.Ingrediente();
			ingrediente.setDescricao(request.getParameter("descricao"));
			ingrediente.setNome(request.getParameter("nome"));
			String tipo[] = request.getParameter("tipo").split("-");
			
			Client client = ClientBuilder.newClient();
			
			ingrediente.setTipoIngrediente(client.target("http://localhost:8080/cruel-ws/TipoIngrediente/"+tipo[0])
					.request(MediaType.APPLICATION_JSON)
					.get(br.ufpr.cruel.model.TipoIngrediente.class));
			
			if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
				ingrediente.setId(Integer.parseInt(request.getParameter("id")));
			}
			
			if(ingrediente.getId() != null){
				client.target("http://localhost:8080/cruel-ws/Ingrediente")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(ingrediente), br.ufpr.cruel.model.Ingrediente.class);
			}else{
				client.target("http://localhost:8080/cruel-ws/Ingrediente")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(ingrediente), br.ufpr.cruel.model.Ingrediente.class);
			}
			
			
			listaIngrediente =  (List<br.ufpr.cruel.model.Ingrediente>) client.target("http://localhost:8080/cruel-ws/Ingrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaIngrediente", listaIngrediente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterIngredientes.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("edit")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			br.ufpr.cruel.model.Ingrediente ingrediente = client.target("http://localhost:8080/cruel-ws/Ingrediente/"+id)
			.request(MediaType.APPLICATION_JSON)
			.get(br.ufpr.cruel.model.Ingrediente.class);
			
			request.setAttribute("ingrediente", ingrediente);
			
			List<TipoIngrediente> listatipoIngrediente =  (List<br.ufpr.cruel.model.TipoIngrediente>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("tipo", listatipoIngrediente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterIngredientes.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("delete")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			client.target("http://localhost:8080/cruel-ws/Ingrediente/"+id)
			.request(MediaType.APPLICATION_JSON)
			.delete(br.ufpr.cruel.model.Ingrediente.class);
			
			listaIngrediente =  (List<br.ufpr.cruel.model.Ingrediente>) client.target("http://localhost:8080/cruel-ws/Ingrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaIngrediente", listaIngrediente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterIngredientes.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("inicio")){
			Client client = ClientBuilder.newClient();
			listaIngrediente =  (List<br.ufpr.cruel.model.Ingrediente>) client.target("http://localhost:8080/cruel-ws/Ingrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaIngrediente", listaIngrediente);
			
			List<TipoIngrediente> listatipoIngrediente =  (List<br.ufpr.cruel.model.TipoIngrediente>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("tipo", listatipoIngrediente);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterIngredientes.jsp");
			rd.forward(request, response);
		}
		
	}

}
