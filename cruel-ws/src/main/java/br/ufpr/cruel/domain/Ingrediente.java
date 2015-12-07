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
	@SequenceGenerator(name="ingrediente_id_seq", sequenceName="ingrediente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ingrediente_id_seq")
	@Column(updatable=false)
	private Integer id;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to TipoIngrediente
	@ManyToOne
	@JoinColumn(name="tipo_ingrediente_id")
	private TipoIngrediente tipoIngrediente;

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

}