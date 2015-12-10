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
 * Servlet implementation class nutricionista
 */
public class Nutricionista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    List<Pessoa> listaPessoa = new ArrayList<>();
    public Nutricionista() {
        super();
        // TODO Auto-generated constructor stub
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
			Pessoa nutricionista = new Pessoa();
			nutricionista.setNome(request.getParameter("nome"));
			nutricionista.setEmail(request.getParameter("email"));
			nutricionista.setCpf(request.getParameter("cpf"));
			nutricionista.setCpf(request.getParameter("crn"));
			nutricionista.setTelefone(request.getParameter("telefone"));
			nutricionista.setSenha(request.getParameter("senha"));
			nutricionista.setEndereco(request.getParameter("endereco"));
			nutricionista.setCrn(request.getParameter("crn"));
			nutricionista.setTipoPessoa("nutricionista");
			
			if(request.getParameter("id") != null){
				nutricionista.setId(Integer.parseInt(request.getParameter("id")));
			}
			
			Client client = ClientBuilder.newClient();
			
			if(nutricionista.getId() != null){
				client.target("http://localhost:8080/cruel-ws/Pessoa")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(nutricionista), br.ufpr.cruel.model.Pessoa.class);
			}else{
				client.target("http://localhost:8080/cruel-ws/Pessoa")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(nutricionista), br.ufpr.cruel.model.Pessoa.class);
			}
			
			listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/Pessoa/tipo/nutricionista")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaNutricionista", listaPessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterNutricionistas.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("edit")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			Pessoa pessoa = client.target("http://localhost:8080/cruel-ws/Pessoa/"+id)
			.request(MediaType.APPLICATION_JSON)
			.get(Pessoa.class);
			
			request.setAttribute("nutricionista", pessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterNutricionistas.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("delete")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			client.target("http://localhost:8080/cruel-ws/Pessoa/"+id)
			.request(MediaType.APPLICATION_JSON)
			.delete(Pessoa.class);
			
			listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/Pessoa/tipo/nutricionista")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaNutricionista", listaPessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterNutricionistas.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("inicio")){
			Client client = ClientBuilder.newClient();
			listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/Pessoa/tipo/nutricionista")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaNutricionista", listaPessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterNutricionistas.jsp");
			rd.forward(request, response);
		}
		
	}

}
