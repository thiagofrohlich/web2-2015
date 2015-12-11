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
 * Servlet implementation class Gerente
 */
public class Gerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Pessoa> listaPessoa = new ArrayList<>();
	
    public Gerente() {
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
			Pessoa gerente = new Pessoa();
			gerente.setNome(request.getParameter("nome"));
			gerente.setCpf(request.getParameter("cpf"));
			gerente.setEmail(request.getParameter("email"));
			gerente.setTelefone(request.getParameter("telefone"));
			gerente.setSenha(request.getParameter("senha"));
			gerente.setEndereco(request.getParameter("endereco"));
			gerente.setTipoPessoa("GERENTE");
			
			if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
				gerente.setId(Integer.parseInt(request.getParameter("id")));
			}
			
			Client client = ClientBuilder.newClient();
			if(gerente.getId() != null){
				client.target("http://localhost:8080/cruel-ws/Pessoa")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(gerente), br.ufpr.cruel.model.Pessoa.class);
			}else{
				client.target("http://localhost:8080/cruel-ws/Pessoa")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(gerente), br.ufpr.cruel.model.Pessoa.class);
			}
			
			
			listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/Pessoa/tipo/GERENTE")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaGerente", listaPessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterGerentes.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("edit")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			Pessoa pessoa = client.target("http://localhost:8080/cruel-ws/Pessoa/"+id)
			.request(MediaType.APPLICATION_JSON)
			.get(Pessoa.class);
			
			request.setAttribute("gerente", pessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterGerentes.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("delete")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Client client = ClientBuilder.newClient();
			client.target("http://localhost:8080/cruel-ws/Pessoa/"+id)
			.request(MediaType.APPLICATION_JSON)
			.delete(Pessoa.class);
			
			listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/Pessoa/tipo/GERENTE")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaGerente", listaPessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterGerentes.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("inicio")){
			Client client = ClientBuilder.newClient();
			listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/Pessoa/tipo/GERENTE")
					.request(MediaType.APPLICATION_JSON)
					.get(ArrayList.class);
			request.setAttribute("listaGerente", listaPessoa);
			
			RequestDispatcher rd = getServletContext().
					getRequestDispatcher("/pages/manterGerentes.jsp");
			rd.forward(request, response);
		}
	}

}
