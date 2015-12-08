package br.ufpr.cruel.domain.dao;

import java.util.Date;
import java.util.List;

import br.ufpr.cruel.domain.Atendimento;
import br.ufpr.cruel.domain.Cardapio;
import br.ufpr.cruel.domain.TipoCliente;

public class AtendimentoDao extends GenericDao<Atendimento, Integer> {

	public AtendimentoDao() {
		super(Atendimento.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> findByTipoCliente(TipoCliente tipoCliente) {
		String query = "select a from Atendimento a "
				+ "where a.tipoCliente = :tipoCliente";
		return (List<Atendimento>) getCurrentSession().createQuery(query).setParameter("tipoCliente", tipoCliente).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> findByData(Date data) {
		String query = "select a from Atendimento a "
				+ "where a.data = :tipoCliente";
		return (List<Atendimento>) getCurrentSession().createQuery(query).setParameter("data", data).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> findBetweenData(Date dataInicio, Date dataFim) {
		String query = "select a from Atendimento a "
				+ "where a.data between :dataInicio and :dataFim";
		return (List<Atendimento>) getCurrentSession().createQuery(query)
				.setParameter("dataInicio", dataInicio)
				.setParameter("dataFim", dataFim).list();
	}

}
