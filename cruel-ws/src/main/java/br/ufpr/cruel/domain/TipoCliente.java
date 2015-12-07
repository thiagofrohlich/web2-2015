package br.ufpr.cruel.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_cliente database table.
 * 
 */
@Entity
@Table(name="tipo_cliente")
@NamedQuery(name="TipoCliente.findAll", query="SELECT t FROM TipoCliente t")
public class TipoCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tipo_cliente_id_seq", sequenceName="tipo_cliente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_cliente_id_seq")
	@Column(updatable=false)
	private Integer id;

	private String descricao;

	@Column(name="valor_refeicao")
	private BigDecimal valorRefeicao;

	public TipoCliente() {
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

	public BigDecimal getValorRefeicao() {
		return this.valorRefeicao;
	}

	public void setValorRefeicao(BigDecimal valorRefeicao) {
		this.valorRefeicao = valorRefeicao;
	}

}