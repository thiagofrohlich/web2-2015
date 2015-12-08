package br.ufpr.cruel.service.transformer;

import java.util.ArrayList;
import java.util.List;

import br.ufpr.cruel.domain.dao.TipoIngredienteDao;
import br.ufpr.cruel.model.Ingrediente;
import br.ufpr.cruel.model.TipoIngrediente;

public class IngredienteTransformer implements Transformer<Ingrediente, br.ufpr.cruel.domain.Ingrediente> {
	
	private TipoIngredienteDao tipoIngredienteDao = new TipoIngredienteDao();
	private Transformer<TipoIngrediente, br.ufpr.cruel.domain.TipoIngrediente> tipoIngredienteTransformer = new TipoIngredienteTransformer();
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToDomain(br.ufpr.cruel.model.Ingrediente)
	 */
	@Override
	public br.ufpr.cruel.domain.Ingrediente transformToDomain(Ingrediente model) {
		br.ufpr.cruel.domain.Ingrediente domain = new br.ufpr.cruel.domain.Ingrediente();
		if(model.getId() == null) {
			domain.setId(model.getId());
		}
		domain.setNome(model.getNome());
		domain.setDescricao(model.getDescricao());
		domain.setTipoIngrediente(findTipoIngrediente(model.getTipoIngrediente()));
		return domain;
	}

	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(br.ufpr.cruel.domain.Ingrediente)
	 */
	@Override
	public Ingrediente transformToModel(br.ufpr.cruel.domain.Ingrediente ingrediente) {
		Ingrediente model = new Ingrediente();
		model.setId(ingrediente.getId());
		model.setNome(ingrediente.getNome());
		model.setDescricao(ingrediente.getDescricao());
		model.setTipoIngrediente(tipoIngredienteTransformer.transformToModel(ingrediente.getTipoIngrediente()));
		return model;
	}
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(java.util.List)
	 */
	@Override
	public List<Ingrediente> transformToModel(List<br.ufpr.cruel.domain.Ingrediente> list) {
		List<Ingrediente> models = new ArrayList<Ingrediente>();
		for(br.ufpr.cruel.domain.Ingrediente tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	

	private br.ufpr.cruel.domain.TipoIngrediente findTipoIngrediente(TipoIngrediente tipoIngrediente) {
		br.ufpr.cruel.domain.TipoIngrediente domain = null;
		tipoIngredienteDao.openCurrentSession();
		domain = tipoIngredienteDao.findById(tipoIngrediente.getId());
		tipoIngredienteDao.closeCurrentSession();
		return domain;
	}

}
