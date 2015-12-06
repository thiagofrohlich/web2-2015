package br.ufpr.cruel.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ingrediente database table.
 * 
 */
@Entity
@Table
@NamedQuery(name="Ingrediente.findAll", query="SELECT i FROM Ingrediente i")
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to TipoIngrediente
	@ManyToOne
	@JoinColumn(name="tipo_ingrediente_id")
	private TipoIngrediente tipoIngrediente;

	//bi-directional many-to-one association to Refeicao
	@OneToMany(mappedBy="ingrediente1")
	private List<Refeicao> refeicaos1;

	//bi-directional many-to-one association to Refeicao
	@OneToMany(mappedBy="ingrediente2")
	private List<Refeicao> refeicaos2;

	//bi-directional many-to-one association to Refeicao
	@OneToMany(mappedBy="ingrediente3")
	private List<Refeicao> refeicaos3;

	//bi-directional many-to-one association to Refeicao
	@OneToMany(mappedBy="ingrediente4")
	private List<Refeicao> refeicaos4;

	//bi-directional many-to-one association to Refeicao
	@OneToMany(mappedBy="ingrediente5")
	private List<Refeicao> refeicaos5;

	//bi-directional many-to-one association to Refeicao
	@OneToMany(mappedBy="ingrediente6")
	private List<Refeicao> refeicaos6;

	public Ingrediente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoIngrediente getTipoIngrediente() {
		return this.tipoIngrediente;
	}

	public void setTipoIngrediente(TipoIngrediente tipoIngrediente) {
		this.tipoIngrediente = tipoIngrediente;
	}

	public List<Refeicao> getRefeicaos1() {
		return this.refeicaos1;
	}

	public void setRefeicaos1(List<Refeicao> refeicaos1) {
		this.refeicaos1 = refeicaos1;
	}

	public Refeicao addRefeicaos1(Refeicao refeicaos1) {
		getRefeicaos1().add(refeicaos1);
		refeicaos1.setIngrediente1(this);

		return refeicaos1;
	}

	public Refeicao removeRefeicaos1(Refeicao refeicaos1) {
		getRefeicaos1().remove(refeicaos1);
		refeicaos1.setIngrediente1(null);

		return refeicaos1;
	}

	public List<Refeicao> getRefeicaos2() {
		return this.refeicaos2;
	}

	public void setRefeicaos2(List<Refeicao> refeicaos2) {
		this.refeicaos2 = refeicaos2;
	}

	public Refeicao addRefeicaos2(Refeicao refeicaos2) {
		getRefeicaos2().add(refeicaos2);
		refeicaos2.setIngrediente2(this);

		return refeicaos2;
	}

	public Refeicao removeRefeicaos2(Refeicao refeicaos2) {
		getRefeicaos2().remove(refeicaos2);
		refeicaos2.setIngrediente2(null);

		return refeicaos2;
	}

	public List<Refeicao> getRefeicaos3() {
		return this.refeicaos3;
	}

	public void setRefeicaos3(List<Refeicao> refeicaos3) {
		this.refeicaos3 = refeicaos3;
	}

	public Refeicao addRefeicaos3(Refeicao refeicaos3) {
		getRefeicaos3().add(refeicaos3);
		refeicaos3.setIngrediente3(this);

		return refeicaos3;
	}

	public Refeicao removeRefeicaos3(Refeicao refeicaos3) {
		getRefeicaos3().remove(refeicaos3);
		refeicaos3.setIngrediente3(null);

		return refeicaos3;
	}

	public List<Refeicao> getRefeicaos4() {
		return this.refeicaos4;
	}

	public void setRefeicaos4(List<Refeicao> refeicaos4) {
		this.refeicaos4 = refeicaos4;
	}

	public Refeicao addRefeicaos4(Refeicao refeicaos4) {
		getRefeicaos4().add(refeicaos4);
		refeicaos4.setIngrediente4(this);

		return refeicaos4;
	}

	public Refeicao removeRefeicaos4(Refeicao refeicaos4) {
		getRefeicaos4().remove(refeicaos4);
		refeicaos4.setIngrediente4(null);

		return refeicaos4;
	}

	public List<Refeicao> getRefeicaos5() {
		return this.refeicaos5;
	}

	public void setRefeicaos5(List<Refeicao> refeicaos5) {
		this.refeicaos5 = refeicaos5;
	}

	public Refeicao addRefeicaos5(Refeicao refeicaos5) {
		getRefeicaos5().add(refeicaos5);
		refeicaos5.setIngrediente5(this);

		return refeicaos5;
	}

	public Refeicao removeRefeicaos5(Refeicao refeicaos5) {
		getRefeicaos5().remove(refeicaos5);
		refeicaos5.setIngrediente5(null);

		return refeicaos5;
	}

	public List<Refeicao> getRefeicaos6() {
		return this.refeicaos6;
	}

	public void setRefeicaos6(List<Refeicao> refeicaos6) {
		this.refeicaos6 = refeicaos6;
	}

	public Refeicao addRefeicaos6(Refeicao refeicaos6) {
		getRefeicaos6().add(refeicaos6);
		refeicaos6.setIngrediente6(this);

		return refeicaos6;
	}

	public Refeicao removeRefeicaos6(Refeicao refeicaos6) {
		getRefeicaos6().remove(refeicaos6);
		refeicaos6.setIngrediente6(null);

		return refeicaos6;
	}

}