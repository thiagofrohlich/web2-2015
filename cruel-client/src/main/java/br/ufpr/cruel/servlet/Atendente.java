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
 * Servlet implementation class Atendente
 */
public class Atendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private List<Pessoa> listaPessoa = new ArrayList<>();
    public Atendente() {
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
		Pessoa atendente = new Pessoa();
		atendente.setNome(request.getParameter("nome"));
		atendente.setEmail(request.getParameter("email"));
		atendente.setTelefone(request.getParameter("telefone"));
		atendente.setSenha(request.getParameter("senha"));
		atendente.setEndereco(request.getParameter("endereco"));
		atendente.setTipoPessoa("atendente");
		
		Client client = ClientBuilder.newClient();
		client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(atendente), br.ufpr.cruel.model.TipoIngrediente.class);
		
		listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
		request.setAttribute("listaTipoIngrediente", listaPessoa);
		
		RequestDispatcher rd = getServletContext().
				getRequestDispatcher("/pages/manterTipoIngrediente.jsp");
				rd.forward(request, response);
	}

}
