package br.ufpr.cruel.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import br.ufpr.cruel.model.Cardapio;

public class InicialCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private SimpleDateFormat format;
	private Cardapio domingo;
	private Cardapio segunda;
	private Cardapio terca;
	private Cardapio quarta;
	private Cardapio quinta;
	private Cardapio sexta;
	private Cardapio sabado;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.setProperty("user.timezone", "UTC");
		TimeZone.setDefault(null);
		format = new SimpleDateFormat("dd/MM/yyyy");
		
		String[] daysofWeek = getDaysofWeek();
		
		Client client = ClientBuilder.newClient();
		List<Cardapio> cardapios = new ArrayList<Cardapio>();
		
		cardapios = Arrays.asList(client.target("http://localhost:8080/cruel-ws/Cardapio/between?dataInicio="+ daysofWeek[0] +"&dataFim="+ daysofWeek[6])
				.request(MediaType.APPLICATION_JSON)
				.get(Cardapio[].class));
		
		populateCardapioSemana(daysofWeek, cardapios);
		
		req.setAttribute("domingo", domingo);
		req.setAttribute("segunda", segunda);
		req.setAttribute("terca", terca);
		req.setAttribute("quarta", quarta);
		req.setAttribute("quinta", quinta);
		req.setAttribute("sexta", sexta);
		req.setAttribute("sabado", sabado);
		getServletContext().getRequestDispatcher("/pages/inicialCliente.jsp").forward(req, resp);
	}

	private void populateCardapioSemana(String[] daysofWeek, List<Cardapio> cardapios) {
		for(Cardapio cardapio : cardapios) {
			if(daysofWeek[0].equals(format.format(cardapio.getData()))) {
				domingo = cardapio;
			} else if(daysofWeek[1].equals(format.format(cardapio.getData()))) {
				segunda = cardapio;
			} else if(daysofWeek[2].equals(format.format(cardapio.getData()))) {
				terca = cardapio;
			} else if(daysofWeek[3].equals(format.format(cardapio.getData()))) {
				quarta = cardapio;
			} else if(daysofWeek[4].equals(format.format(cardapio.getData()))) {
				quinta = cardapio;
			} else if(daysofWeek[5].equals(format.format(cardapio.getData()))) {
				sexta = cardapio;
			} else if(daysofWeek[6].equals(format.format(cardapio.getData()))) {
				sabado = cardapio;
			}
		}
	}

	private String[] getDaysofWeek() {
	    Calendar now = Calendar.getInstance();

	    String[] days = new String[7];
	    int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1; //add 2 if your week start on monday
	    now.add(Calendar.DAY_OF_MONTH, delta );
	    for (int i = 0; i < 7; i++)
	    {
	        days[i] = format.format(now.getTime());
	        now.add(Calendar.DAY_OF_MONTH, 1);
	    }
//	    System.out.println(Arrays.toString(days));	
	    return days;
	}

	public Cardapio getSegunda() {
		return segunda;
	}

	public void setSegunda(Cardapio segunda) {
		this.segunda = segunda;
	}

	public Cardapio getDomingo() {
		return domingo;
	}

	public void setDomingo(Cardapio domingo) {
		this.domingo = domingo;
	}

	public Cardapio getTerca() {
		return terca;
	}

	public void setTerca(Cardapio terca) {
		this.terca = terca;
	}

	public Cardapio getQuarta() {
		return quarta;
	}

	public void setQuarta(Cardapio quarta) {
		this.quarta = quarta;
	}

	public Cardapio getQuinta() {
		return quinta;
	}

	public void setQuinta(Cardapio quinta) {
		this.quinta = quinta;
	}

	public Cardapio getSexta() {
		return sexta;
	}

	public void setSexta(Cardapio sexta) {
		this.sexta = sexta;
	}

	public Cardapio getSabado() {
		return sabado;
	}

	public void setSabado(Cardapio sabado) {
		this.sabado = sabado;
	}
	
}
