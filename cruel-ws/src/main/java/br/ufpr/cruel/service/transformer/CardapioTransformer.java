package br.ufpr.cruel.service.transformer;

import java.util.ArrayList;
import java.util.List;

import br.ufpr.cruel.domain.dao.RefeicaoDao;
import br.ufpr.cruel.model.Cardapio;
import br.ufpr.cruel.model.Refeicao;

public class CardapioTransformer implements Transformer<Cardapio, br.ufpr.cruel.domain.Cardapio> {
	
	private RefeicaoDao refeicaoDao = new RefeicaoDao();
	private Transformer<Refeicao, br.ufpr.cruel.domain.Refeicao> refeicaoTransformer = new RefeicaoTransformer();
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToDomain(br.ufpr.cruel.model.Cardapio)
	 */
	@Override
	public br.ufpr.cruel.domain.Cardapio transformToDomain(Cardapio model) {
		br.ufpr.cruel.domain.Cardapio domain = new br.ufpr.cruel.domain.Cardapio();
		if(model.getId() == null) {
			domain.setId(model.getId());
		}
		domain.setData(model.getData());
		domain.setRefeicao1(findRefeicao(model.getRefeicao1()));
		domain.setRefeicao2(findRefeicao(model.getRefeicao2()));
		return domain;
	}

	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(br.ufpr.cruel.domain.Cardapio)
	 */
	@Override
	public Cardapio transformToModel(br.ufpr.cruel.domain.Cardapio cardapio) {
		Cardapio model = new Cardapio();
		model.setId(cardapio.getId());
		model.setData(cardapio.getData());
		model.setRefeicao1(refeicaoTransformer.transformToModel(cardapio.getRefeicao1()));
		model.setRefeicao2(refeicaoTransformer.transformToModel(cardapio.getRefeicao2()));
		return model;
	}
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(java.util.List)
	 */
	@Override
	public List<Cardapio> transformToModel(List<br.ufpr.cruel.domain.Cardapio> list) {
		List<Cardapio> models = new ArrayList<Cardapio>();
		for(br.ufpr.cruel.domain.Cardapio tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}

	private br.ufpr.cruel.domain.Refeicao findRefeicao(Refeicao refeicao) {
		br.ufpr.cruel.domain.Refeicao domain = null;
		refeicaoDao.openCurrentSession();
		domain = refeicaoDao.findById(refeicao.getId());
		refeicaoDao.closeCurrentSession();
		return domain;
	}

}
