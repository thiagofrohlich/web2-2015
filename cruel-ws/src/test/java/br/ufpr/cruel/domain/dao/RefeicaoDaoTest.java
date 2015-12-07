package br.ufpr.cruel.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpr.cruel.domain.Ingrediente;
import br.ufpr.cruel.domain.Refeicao;
import br.ufpr.cruel.domain.TipoIngrediente;

public class RefeicaoDaoTest {
	
	private TipoIngredienteDao tipoIngredienteDao;
	private IngredienteDao ingredienteDao;
	private RefeicaoDao dao;
	private List<Refeicao> list;
	private Ingrediente ingrediente;

	@Before
	public void setUp() {
		dao = new RefeicaoDao();
		tipoIngredienteDao = new TipoIngredienteDao();
		ingredienteDao = new IngredienteDao();
		list = new ArrayList<Refeicao>();
		ingrediente = createIngrediente(createTipoIngrediente());
	}
	
	@After
	public void clearTests() {
		dao.openCurrentSessionwithTransaction();
		for(Refeicao tipo : list) {
			dao.delete(tipo);
		}
		dao.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void shouldPersistRefeicao() {
		Refeicao refeicao = new Refeicao();
		refeicao.setTipoRefeicao("test");
		refeicao.setIngrediente1(ingrediente);
		refeicao.setIngrediente2(ingrediente);
		refeicao.setIngrediente3(ingrediente);
		refeicao.setIngrediente4(ingrediente);
		refeicao.setIngrediente5(ingrediente);
		refeicao.setIngrediente6(ingrediente);
		
		persist(refeicao);
		List<Refeicao> savedRefeicao = findByTipoRefeicao(refeicao.getTipoRefeicao());
		
		assertNotNull(savedRefeicao);
		assertNotNull(savedRefeicao.get(0));
		assertEquals(savedRefeicao.get(0).getTipoRefeicao(), refeicao.getTipoRefeicao());
		assertEquals(savedRefeicao.get(0).getIngrediente1().getId(), refeicao.getIngrediente1().getId());
		assertEquals(savedRefeicao.get(0).getIngrediente2().getId(), refeicao.getIngrediente2().getId());
		assertEquals(savedRefeicao.get(0).getIngrediente3().getId(), refeicao.getIngrediente3().getId());
		assertEquals(savedRefeicao.get(0).getIngrediente4().getId(), refeicao.getIngrediente4().getId());
		assertEquals(savedRefeicao.get(0).getIngrediente5().getId(), refeicao.getIngrediente5().getId());
		assertEquals(savedRefeicao.get(0).getIngrediente6().getId(), refeicao.getIngrediente6().getId());
	}
	
	private List<Refeicao> findByTipoRefeicao(String tipoRefeicao) {
		dao.openCurrentSession();
		list.addAll(dao.findByTipoRefeicao(tipoRefeicao));
		dao.closeCurrentSession();
		return list;
	}

	private void persist(Refeicao refeicao) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(refeicao);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private TipoIngrediente createTipoIngrediente() {
		TipoIngrediente tipoIngrediente = new TipoIngrediente();
		tipoIngrediente.setNome("test");
		
		tipoIngredienteDao.openCurrentSessionwithTransaction();
		tipoIngredienteDao.persist(tipoIngrediente);
		tipoIngredienteDao.getCurrentSession().flush();
		tipoIngredienteDao.getCurrentSession().clear();
		tipoIngredienteDao.getCurrentTransaction().commit();
		tipoIngredienteDao.closeCurrentSession();
		
		return findTipoIngredienteByNome(tipoIngrediente.getNome());
	}
	
	private TipoIngrediente findTipoIngredienteByNome(String nome) {
		TipoIngrediente tipoIngrediente = null;
		tipoIngredienteDao.openCurrentSession();
		tipoIngrediente = tipoIngredienteDao.findByNome(nome).get(0);
		tipoIngredienteDao.closeCurrentSession();
		return tipoIngrediente;
	}
	
	private Ingrediente createIngrediente(TipoIngrediente tipoIngrediente) {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome("test");
		ingrediente.setDescricao("test_dsc");
		ingrediente.setTipoIngrediente(tipoIngrediente);
		
		ingredienteDao.openCurrentSessionwithTransaction();
		ingredienteDao.persist(ingrediente);
		ingredienteDao.getCurrentSession().flush();
		ingredienteDao.getCurrentSession().clear();
		ingredienteDao.getCurrentTransaction().commit();
		ingredienteDao.closeCurrentSession();
		
		return findIngredienteByNome(ingrediente.getNome());
	}
	
	private Ingrediente findIngredienteByNome(String nome) {
		Ingrediente ingrediente = null;
		ingredienteDao.openCurrentSession();
		ingrediente = ingredienteDao.findByNome(nome).get(0);
		ingredienteDao.closeCurrentSession();
		return ingrediente;
	}
	
}
