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
		Pessoa nutricionista = new Pessoa();
		nutricionista.setNome(request.getParameter("nome"));
		nutricionista.setEmail(request.getParameter("email"));
		nutricionista.setTelefone(request.getParameter("telefone"));
		nutricionista.setSenha(request.getParameter("senha"));
		nutricionista.setEndereco(request.getParameter("endereco"));
		nutricionista.setCrn(request.getParameter("crn"));
		nutricionista.setTipoPessoa("nutricionista");
		
		Client client = ClientBuilder.newClient();
		client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(nutricionista), br.ufpr.cruel.model.TipoIngrediente.class);
		
		listaPessoa =  (List<Pessoa>) client.target("http://localhost:8080/cruel-ws/TipoIngrediente")
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
		request.setAttribute("listaTipoIngrediente", listaPessoa);
		
		RequestDispatcher rd = getServletContext().
				getRequestDispatcher("/pages/manterTipoIngrediente.jsp");
				rd.forward(request, response);
	}

}
