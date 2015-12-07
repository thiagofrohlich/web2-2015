package br.ufpr.cruel.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpr.cruel.domain.Atendimento;
import br.ufpr.cruel.domain.TipoCliente;

public class AtendimentoDaoTest {
	
	private TipoClienteDao tipoClienteDao;
	private AtendimentoDao dao;
	private List<Atendimento> list;
	private TipoCliente tipoCliente;

	@Before
	public void setUp() {
		dao = new AtendimentoDao();
		tipoClienteDao = new TipoClienteDao();
		list = new ArrayList<Atendimento>();
		tipoCliente = createTipoCliente();
	}
	
	@After
	public void clearTests() {
		dao.openCurrentSessionwithTransaction();
		for(Atendimento tipo : list) {
			dao.delete(tipo);
		}
		dao.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void shouldPersistAtendimento() {
		Atendimento atendimento = new Atendimento();
		atendimento.setTipoCliente(tipoCliente);
		atendimento.setValor(tipoCliente.getValorRefeicao());
		atendimento.setData(new Date());
		
		persist(atendimento);
		List<Atendimento> savedAtendimento = findByTipoCliente(atendimento.getTipoCliente());
		
		assertNotNull(savedAtendimento);
		assertNotNull(savedAtendimento.get(0));
		assertEquals(savedAtendimento.get(0).getTipoCliente(), atendimento.getTipoCliente());
		assertEquals(savedAtendimento.get(0).getValor(), atendimento.getValor());
		assertEquals(savedAtendimento.get(0).getData(), atendimento.getData());
	}
	
	private List<Atendimento> findByTipoCliente(TipoCliente tipoCliente) {
		dao.openCurrentSession();
		list.addAll(dao.findByTipoCliente(tipoCliente));
		dao.closeCurrentSession();
		return list;
	}

	private void persist(Atendimento atendimento) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(atendimento);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private TipoCliente createTipoCliente() {
		TipoCliente tipoCliente = new TipoCliente();
		tipoCliente.setValorRefeicao(new BigDecimal(99.99).setScale(2, BigDecimal.ROUND_HALF_UP));
		tipoCliente.setDescricao("test");
		
		tipoClienteDao.openCurrentSessionwithTransaction();
		tipoClienteDao.persist(tipoCliente);
		tipoClienteDao.getCurrentSession().flush();
		tipoClienteDao.getCurrentSession().clear();
		tipoClienteDao.getCurrentTransaction().commit();
		tipoClienteDao.closeCurrentSession();
		
		return findTipoClienteByDescricao(tipoCliente.getDescricao());
	}
	
	private TipoCliente findTipoClienteByDescricao(String descricao) {
		TipoCliente tipoCliente = null;
		tipoClienteDao.openCurrentSession();
		tipoCliente = tipoClienteDao.findByDescricao(descricao).get(0);
		tipoClienteDao.closeCurrentSession();
		return tipoCliente;
	}

}
