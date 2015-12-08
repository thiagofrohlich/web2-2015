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

import br.ufpr.cruel.model.Pessoa;

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
		br.ufpr.cruel.model.Ingrediente ingrediente= new br.ufpr.cruel.model.Ingrediente();
		ingrediente.setDescricao(request.getParameter("descricao"));
		ingrediente.setNome(request.getParameter("nome"));
		ingrediente.getTipoIngrediente().setNome(request.getParameter("tipo"));
		
		Client client = ClientBuilder.newClient();
		client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(ingrediente), br.ufpr.cruel.model.TipoIngrediente.class);
		
		listaIngrediente =  (List<br.ufpr.cruel.model.Ingrediente>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
		request.setAttribute("listaTipoIngrediente", listaIngrediente);
		
		RequestDispatcher rd = getServletContext().
				getRequestDispatcher("/pages/manterTipoIngrediente.jsp");
				rd.forward(request, response);
	}

}
