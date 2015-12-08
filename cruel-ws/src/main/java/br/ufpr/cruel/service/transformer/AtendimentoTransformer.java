package br.ufpr.cruel.service.transformer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.ufpr.cruel.domain.TipoCliente;
import br.ufpr.cruel.domain.dao.TipoClienteDao;
import br.ufpr.cruel.model.Atendimento;

public class AtendimentoTransformer implements Transformer<Atendimento, br.ufpr.cruel.domain.Atendimento> {
	
	private TipoClienteDao tipoClienteDao = new TipoClienteDao();
	private Transformer<br.ufpr.cruel.model.TipoCliente, TipoCliente> tipoClienteTransformer = new TipoClienteTransformer();
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToDomain(br.ufpr.cruel.model.Atendimento)
	 */
	@Override
	public br.ufpr.cruel.domain.Atendimento transformToDomain(Atendimento model) {
		br.ufpr.cruel.domain.Atendimento domain = new br.ufpr.cruel.domain.Atendimento();
		if(model.getId() == null) {
			domain.setId(model.getId());
		}
		domain.setData(model.getData());
		domain.setTipoCliente(findTipoCliente(model.getTipoCliente()));
		domain.setValor(new BigDecimal(model.getValor().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
		return domain;
	}

	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(br.ufpr.cruel.domain.Atendimento)
	 */
	@Override
	public Atendimento transformToModel(br.ufpr.cruel.domain.Atendimento atendimento) {
		Atendimento model = new Atendimento();
		model.setId(atendimento.getId());
		model.setData(atendimento.getData());
		model.setTipoCliente(tipoClienteTransformer.transformToModel(atendimento.getTipoCliente()));
		model.setValor(new BigDecimal(atendimento.getValor().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
		return model;
	}
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(java.util.List)
	 */
	@Override
	public List<Atendimento> transformToModel(List<br.ufpr.cruel.domain.Atendimento> list) {
		List<Atendimento> models = new ArrayList<Atendimento>();
		for(br.ufpr.cruel.domain.Atendimento tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	
	private TipoCliente findTipoCliente(br.ufpr.cruel.model.TipoCliente tipoCliente) {
		TipoCliente domain = null;
		tipoClienteDao.openCurrentSession();
		domain = tipoClienteDao.findById(tipoCliente.getId());
		tipoClienteDao.closeCurrentSession();
		return domain;
	}

}
