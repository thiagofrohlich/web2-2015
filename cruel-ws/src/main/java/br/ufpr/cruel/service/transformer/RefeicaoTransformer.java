package br.ufpr.cruel.service.transformer;

import java.util.ArrayList;
import java.util.List;

import br.ufpr.cruel.domain.dao.IngredienteDao;
import br.ufpr.cruel.model.Ingrediente;
import br.ufpr.cruel.model.Refeicao;

public class RefeicaoTransformer implements Transformer<Refeicao, br.ufpr.cruel.domain.Refeicao> {
	
	private IngredienteDao ingredienteDao = new IngredienteDao();
	private Transformer<Ingrediente, br.ufpr.cruel.domain.Ingrediente> ingredienteTransformer = new IngredienteTransformer();
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToDomain(br.ufpr.cruel.model.Refeicao)
	 */
	@Override
	public br.ufpr.cruel.domain.Refeicao transformToDomain(Refeicao model) {
		br.ufpr.cruel.domain.Refeicao domain = new br.ufpr.cruel.domain.Refeicao();
		if(model.getId() == null) {
			domain.setId(model.getId());
		}
		domain.setTipoRefeicao(model.getTipoRefeicao());
		domain.setIngrediente1(findIngrediente(model.getIngrediente1()));
		domain.setIngrediente2(findIngrediente(model.getIngrediente2()));
		domain.setIngrediente3(findIngrediente(model.getIngrediente3()));
		domain.setIngrediente4(findIngrediente(model.getIngrediente4()));
		domain.setIngrediente5(findIngrediente(model.getIngrediente5()));
		domain.setIngrediente6(findIngrediente(model.getIngrediente6()));
		return domain;
	}

	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(br.ufpr.cruel.domain.Refeicao)
	 */
	@Override
	public Refeicao transformToModel(br.ufpr.cruel.domain.Refeicao refeicao) {
		Refeicao model = new Refeicao();
		model.setId(refeicao.getId());
		model.setTipoRefeicao(refeicao.getTipoRefeicao());
		model.setIngrediente1(ingredienteTransformer.transformToModel(refeicao.getIngrediente1()));
		model.setIngrediente2(ingredienteTransformer.transformToModel(refeicao.getIngrediente2()));
		model.setIngrediente3(ingredienteTransformer.transformToModel(refeicao.getIngrediente3()));
		model.setIngrediente4(ingredienteTransformer.transformToModel(refeicao.getIngrediente4()));
		model.setIngrediente5(ingredienteTransformer.transformToModel(refeicao.getIngrediente5()));
		model.setIngrediente6(ingredienteTransformer.transformToModel(refeicao.getIngrediente6()));
		return model;
	}
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(java.util.List)
	 */
	@Override
	public List<Refeicao> transformToModel(List<br.ufpr.cruel.domain.Refeicao> list) {
		List<Refeicao> models = new ArrayList<Refeicao>();
		for(br.ufpr.cruel.domain.Refeicao tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}

	private br.ufpr.cruel.domain.Ingrediente findIngrediente(Ingrediente ingrediente) {
		br.ufpr.cruel.domain.Ingrediente ingredienteDomain = null;
		ingredienteDao.openCurrentSession();
		ingredienteDomain = ingredienteDao.findById(ingrediente.getId());
		ingredienteDao.closeCurrentSession();
		return ingredienteDomain;
	}

}
