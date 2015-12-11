package br.ufpr.cruel.service.transformer;

import java.util.ArrayList;
import java.util.List;

import br.ufpr.cruel.model.Pessoa;

public class PessoaTransformer implements Transformer<Pessoa, br.ufpr.cruel.domain.Pessoa> {
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToDomain(br.ufpr.cruel.model.Pessoa)
	 */
	@Override
	public br.ufpr.cruel.domain.Pessoa transformToDomain(Pessoa model) {
		br.ufpr.cruel.domain.Pessoa domain = new br.ufpr.cruel.domain.Pessoa();
		if(model.getId() != null) {
			domain.setId(model.getId());
		}
		domain.setCpf(model.getCpf());
		domain.setCrn(model.getCrn());
		domain.setEmail(model.getEmail());
		domain.setEndereco(model.getEndereco());
		domain.setNome(model.getNome());
		domain.setSenha(model.getSenha()); //encrypt
		domain.setTelefone(model.getTelefone());
		domain.setTipoPessoa(model.getTipoPessoa());
		return domain;
	}

	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(br.ufpr.cruel.domain.Pessoa)
	 */
	@Override
	public Pessoa transformToModel(br.ufpr.cruel.domain.Pessoa pessoa) {

		Pessoa model = new Pessoa();
		if(pessoa != null) {
			model = new Pessoa();
			model.setId(pessoa.getId());
			model.setCpf(pessoa.getCpf());
			model.setCrn(pessoa.getCrn());
			model.setEmail(pessoa.getEmail());
			model.setEndereco(pessoa.getEndereco());
			model.setNome(pessoa.getNome());
			model.setSenha(pessoa.getSenha());
			model.setTelefone(pessoa.getTelefone());
			model.setTipoPessoa(pessoa.getTipoPessoa());
		}

		return model;
	}
	
	/* (non-Javadoc)
	 * @see br.ufpr.cruel.service.transformer.Transformer#transformToModel(java.util.List)
	 */
	@Override
	public List<Pessoa> transformToModel(List<br.ufpr.cruel.domain.Pessoa> list) {
		List<Pessoa> models = new ArrayList<Pessoa>();
		for(br.ufpr.cruel.domain.Pessoa tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	

}
