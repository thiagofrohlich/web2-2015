package br.ufpr.cruel.domain.dao;

import java.util.List;

import br.ufpr.cruel.domain.Ingrediente;

public class IngredienteDao extends GenericDao<Ingrediente, Integer> {

	public IngredienteDao() {
		super(Ingrediente.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> findByNome(String nome) {
		String query = "select i from Ingrediente i "
				+ "where i.nome like :nome";
		return (List<Ingrediente>) getCurrentSession().createQuery(query).setParameter("nome", nome).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> findByDescricao(String descricao) {
		String query = "select i from Ingrediente i "
				+ "where i.descricao like :descricao";
		return (List<Ingrediente>) getCurrentSession().createQuery(query).setParameter("descricao", descricao).list();
	}

}
