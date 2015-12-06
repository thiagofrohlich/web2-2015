package br.ufpr.cruel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String descricao;

	private BigDecimal valorRefeicao;

	private List<Atendimento> atendimentos;

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

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setTipoCliente(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setTipoCliente(null);

		return atendimento;
	}

}