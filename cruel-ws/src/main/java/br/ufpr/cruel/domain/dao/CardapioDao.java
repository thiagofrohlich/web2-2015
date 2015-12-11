package br.ufpr.cruel.domain.dao;

import java.util.Date;
import java.util.List;

import br.ufpr.cruel.domain.Cardapio;

public class CardapioDao extends GenericDao<Cardapio, Integer> {

	public CardapioDao() {
		super(Cardapio.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cardapio> findByData(Date data) {
		String query = "select ca from Cardapio ca "
				+ "where ca.data = :data";
		return (List<Cardapio>) getCurrentSession().createQuery(query).setParameter("data", data).list();
	}

	@SuppressWarnings("unchecked")
	public List<Cardapio> findBetweenData(Date dataInicio, Date dataFim) {
		String query = "select ca from Cardapio ca "
				+ "where ca.data between :dataInicio and :dataFim "
				+ "order by ca.data asc";
		return (List<Cardapio>) getCurrentSession().createQuery(query)
				.setParameter("dataInicio", dataInicio)
				.setParameter("dataFim", dataFim).list();
	}
	
}
