package br.ufpr.cruel.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

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

}