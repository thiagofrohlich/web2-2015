package br.ufpr.cruel.model;

import java.io.Serializable;
import java.util.List;


public class TipoIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private List<Ingrediente> ingredientes;

	public TipoIngrediente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Ingrediente addIngrediente(Ingrediente ingrediente) {
		getIngredientes().add(ingrediente);
		ingrediente.setTipoIngrediente(this);

		return ingrediente;
	}

	public Ingrediente removeIngrediente(Ingrediente ingrediente) {
		getIngredientes().remove(ingrediente);
		ingrediente.setTipoIngrediente(null);

		return ingrediente;
	}

}