package br.ufpr.cruel.service.transformer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.ufpr.cruel.model.TipoCliente;

public class TipoClienteTransformer implements Transformer<TipoCliente, br.ufpr.cruel.domain.TipoCliente> {
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToDomain(br.ufpr.cruel.model.TipoCliente)
	 */
	@Override
	public br.ufpr.cruel.domain.TipoCliente transformToDomain(TipoCliente model) {
		br.ufpr.cruel.domain.TipoCliente domain = new br.ufpr.cruel.domain.TipoCliente();
		if(model.getId() == null) {
			domain.setId(model.getId());
		}
		domain.setDescricao(model.getDescricao());
		domain.setValorRefeicao(new BigDecimal(model.getValorRefeicao().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
		return domain;
	}

	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(br.ufpr.cruel.domain.TipoCliente)
	 */
	@Override
	public TipoCliente transformToModel(br.ufpr.cruel.domain.TipoCliente tipoCliente) {
		TipoCliente model = null;
		if(tipoCliente != null) {
			model = new TipoCliente();
			model.setId(tipoCliente.getId());
			model.setDescricao(tipoCliente.getDescricao());
			model.setValorRefeicao(new BigDecimal(tipoCliente.getValorRefeicao().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		return model;
	}
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(java.util.List)
	 */
	@Override
	public List<TipoCliente> transformToModel(List<br.ufpr.cruel.domain.TipoCliente> list) {
		List<TipoCliente> models = new ArrayList<TipoCliente>();
		for(br.ufpr.cruel.domain.TipoCliente tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	

}
