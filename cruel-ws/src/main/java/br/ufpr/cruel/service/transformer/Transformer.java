package br.ufpr.cruel.service.transformer;

import java.util.List;

public interface Transformer<Model, Domain> {

	Domain transformToDomain(Model model);

	Model transformToModel(Domain domain);

	List<Model> transformToModel(List<Domain> domainList);

}