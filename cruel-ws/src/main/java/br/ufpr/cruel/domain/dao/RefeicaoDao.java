package br.ufpr.cruel.domain.dao;

import java.util.List;

import br.ufpr.cruel.domain.Refeicao;

public class RefeicaoDao extends GenericDao<Refeicao, Integer> {

	public RefeicaoDao() {
		super(Refeicao.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Refeicao> findByTipoRefeicao(String tipoRefeicao) {
		String query = "select ti from Refeicao ti "
				+ "where ti.tipoRefeicao like :tipoRefeicao";
		return (List<Refeicao>) getCurrentSession().createQuery(query).setParameter("tipoRefeicao", tipoRefeicao).list();
	}

}
