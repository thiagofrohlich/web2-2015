package br.ufpr.cruel.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cardapio implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date data;

	private Refeicao refeicao1;

	private Refeicao refeicao2;

	public Cardapio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Refeicao getRefeicao1() {
		return this.refeicao1;
	}

	public void setRefeicao1(Refeicao refeicao1) {
		this.refeicao1 = refeicao1;
	}

	public Refeicao getRefeicao2() {
		return this.refeicao2;
	}

	public void setRefeicao2(Refeicao refeicao2) {
		this.refeicao2 = refeicao2;
	}

}