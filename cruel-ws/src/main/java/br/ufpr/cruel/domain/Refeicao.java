package br.ufpr.cruel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the refeicao database table.
 * 
 */
@Entity
@NamedQuery(name="Refeicao.findAll", query="SELECT r FROM Refeicao r")
public class Refeicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="refeicao_id_seq", sequenceName="refeicao_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="refeicao_id_seq")
	@Column(updatable=false)
	private Integer id;

	@Column(name="tipo_refeicao")
	private String tipoRefeicao;

	//bi-directional many-to-one association to Ingrediente
	@ManyToOne
	@JoinColumn(name="arroz_id")
	private Ingrediente ingrediente1;

	//bi-directional many-to-one association to Ingrediente
	@ManyToOne
	@JoinColumn(name="carne_id")
	private Ingrediente ingrediente2;

	//bi-directional many-to-one association to Ingrediente
	@ManyToOne
	@JoinColumn(name="feijao_id")
	private Ingrediente ingrediente3;

	//bi-directional many-to-one association to Ingrediente
	@ManyToOne
	@JoinColumn(name="acompanhamento_id")
	private Ingrediente ingrediente4;

	//bi-directional many-to-one association to Ingrediente
	@ManyToOne
	@JoinColumn(name="salada_id")
	private Ingrediente ingrediente5;

	//bi-directional many-to-one association to Ingrediente
	@ManyToOne
	@JoinColumn(name="sobremesa_id")
	private Ingrediente ingrediente6;

	public Refeicao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoRefeicao() {
		return this.tipoRefeicao;
	}

	public void setTipoRefeicao(String tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public Ingrediente getIngrediente1() {
		return this.ingrediente1;
	}

	public void setIngrediente1(Ingrediente ingrediente1) {
		this.ingrediente1 = ingrediente1;
	}

	public Ingrediente getIngrediente2() {
		return this.ingrediente2;
	}

	public void setIngrediente2(Ingrediente ingrediente2) {
		this.ingrediente2 = ingrediente2;
	}

	public Ingrediente getIngrediente3() {
		return this.ingrediente3;
	}

	public void setIngrediente3(Ingrediente ingrediente3) {
		this.ingrediente3 = ingrediente3;
	}

	public Ingrediente getIngrediente4() {
		return this.ingrediente4;
	}

	public void setIngrediente4(Ingrediente ingrediente4) {
		this.ingrediente4 = ingrediente4;
	}

	public Ingrediente getIngrediente5() {
		return this.ingrediente5;
	}

	public void setIngrediente5(Ingrediente ingrediente5) {
		this.ingrediente5 = ingrediente5;
	}

	public Ingrediente getIngrediente6() {
		return this.ingrediente6;
	}

	public void setIngrediente6(Ingrediente ingrediente6) {
		this.ingrediente6 = ingrediente6;
	}

}