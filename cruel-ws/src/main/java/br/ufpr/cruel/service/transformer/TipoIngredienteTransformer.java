package br.ufpr.cruel.service.transformer;

import java.util.ArrayList;
import java.util.List;

import br.ufpr.cruel.model.TipoIngrediente;

public class TipoIngredienteTransformer implements Transformer<TipoIngrediente, br.ufpr.cruel.domain.TipoIngrediente> {
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToDomain(br.ufpr.cruel.model.TipoIngrediente)
	 */
	@Override
	public br.ufpr.cruel.domain.TipoIngrediente transformToDomain(TipoIngrediente model) {
		br.ufpr.cruel.domain.TipoIngrediente domain = new br.ufpr.cruel.domain.TipoIngrediente();
		if(model.getId() != null) {
			domain.setId(model.getId());
		}
		domain.setNome(model.getNome());
		return domain;
	}

	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(br.ufpr.cruel.domain.TipoIngrediente)
	 */
	@Override
	public TipoIngrediente transformToModel(br.ufpr.cruel.domain.TipoIngrediente tipoIngrediente) {
		TipoIngrediente model = null;
		if(tipoIngrediente != null) {
			model = new TipoIngrediente();
			model.setId(tipoIngrediente.getId());
			model.setNome(tipoIngrediente.getNome());
		}
		return model;
	}
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(java.util.List)
	 */
	@Override
	public List<TipoIngrediente> transformToModel(List<br.ufpr.cruel.domain.TipoIngrediente> list) {
		List<TipoIngrediente> models = new ArrayList<TipoIngrediente>();
		for(br.ufpr.cruel.domain.TipoIngrediente tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	

}
