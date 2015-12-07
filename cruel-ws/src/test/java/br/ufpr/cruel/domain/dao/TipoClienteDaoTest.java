package br.ufpr.cruel.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpr.cruel.domain.TipoCliente;

public class TipoClienteDaoTest {
	
	private TipoClienteDao dao;
	private List<TipoCliente> list;

	@Before
	public void setUp() {
		dao = new TipoClienteDao();
		list = new ArrayList<TipoCliente>();
	}
	
	@After
	public void clearTests() {
		dao.openCurrentSessionwithTransaction();
		for(TipoCliente tipo : list) {
			dao.delete(tipo);
		}
		dao.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void shouldPersistTipoCliente() {
		TipoCliente tipoCliente = new TipoCliente();
		tipoCliente.setValorRefeicao(new BigDecimal(99.99).setScale(2, BigDecimal.ROUND_HALF_UP));
		tipoCliente.setDescricao("test");
		
		persist(tipoCliente);
		List<TipoCliente> savedTipoCliente = findByDescricao(tipoCliente.getDescricao());
		
		assertNotNull(savedTipoCliente);
		assertNotNull(savedTipoCliente.get(0));
		assertEquals(savedTipoCliente.get(0).getDescricao(), tipoCliente.getDescricao());
		assertEquals(savedTipoCliente.get(0).getValorRefeicao(), tipoCliente.getValorRefeicao());
	}
	
	private List<TipoCliente> findByDescricao(String descricao) {
		dao.openCurrentSession();
		list.addAll(dao.findByDescricao(descricao));
		dao.closeCurrentSession();
		return list;
	}

	private void persist(TipoCliente tipoCliente) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(tipoCliente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
}
