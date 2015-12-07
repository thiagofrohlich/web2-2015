package br.ufpr.cruel.domain.dao;

import java.util.List;

import br.ufpr.cruel.domain.TipoCliente;

public class TipoClienteDao extends GenericDao<TipoCliente, Integer> {

	public TipoClienteDao() {
		super(TipoCliente.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoCliente> findByDescricao(String descricao) {
		String query = "select ti from TipoCliente ti "
				+ "where ti.descricao like :descricao";
		return (List<TipoCliente>) getCurrentSession().createQuery(query).setParameter("descricao", descricao).list();
	}

}
