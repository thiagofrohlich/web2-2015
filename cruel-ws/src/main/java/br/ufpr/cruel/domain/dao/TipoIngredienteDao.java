package br.ufpr.cruel.domain.dao;

import java.util.List;

import br.ufpr.cruel.domain.TipoIngrediente;

public class TipoIngredienteDao extends GenericDao<TipoIngrediente, Integer> {

	public TipoIngredienteDao() {
		super(TipoIngrediente.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoIngrediente> findByNome(String nome) {
		String query = "select ti from TipoIngrediente ti "
				+ "where ti.nome like :nome";
		return (List<TipoIngrediente>) getCurrentSession().createQuery(query).setParameter("nome", nome).list();
	}

}
