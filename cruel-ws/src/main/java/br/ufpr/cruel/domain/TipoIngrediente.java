package br.ufpr.cruel.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_ingrediente database table.
 * 
 */
@Entity
@Table(name="tipo_ingrediente")
@NamedQuery(name="TipoIngrediente.findAll", query="SELECT t FROM TipoIngrediente t")
public class TipoIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tipo_ingrediente_id_seq", sequenceName="tipo_ingrediente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_ingrediente_id_seq")
	@Column(updatable=false)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Ingrediente
	@OneToMany(mappedBy="tipoIngrediente")
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