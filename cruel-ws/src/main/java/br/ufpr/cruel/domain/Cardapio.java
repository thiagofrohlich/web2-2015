package br.ufpr.cruel.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cardapio database table.
 * 
 */
@Entity
@NamedQuery(name="Cardapio.findAll", query="SELECT c FROM Cardapio c")
public class Cardapio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="cardapio_id_seq", sequenceName="cardapio_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cardapio_id_seq")
	@Column(updatable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date data;

	//bi-directional many-to-one association to Refeicao
	@ManyToOne
	@JoinColumn(name="almoco_id")
	private Refeicao refeicao1;

	//bi-directional many-to-one association to Refeicao
	@ManyToOne
	@JoinColumn(name="jantar_id")
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