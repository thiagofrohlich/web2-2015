package br.ufpr.cruel.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpr.cruel.domain.Ingrediente;
import br.ufpr.cruel.domain.TipoIngrediente;

public class IngredienteDaoTest {
	
	private TipoIngredienteDao tipoIngredienteDao;
	private IngredienteDao dao;
	private List<Ingrediente> list;
	private TipoIngrediente tipoIngrediente;

	@Before
	public void setUp() {
		dao = new IngredienteDao();
		tipoIngredienteDao = new TipoIngredienteDao();
		list = new ArrayList<Ingrediente>();
		tipoIngrediente = createTipoIngrediente();
	}
	
	@After
	public void clearTests() {
		dao.openCurrentSessionwithTransaction();
		for(Ingrediente tipo : list) {
			dao.delete(tipo);
		}
		dao.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void shouldPersistIngrediente() {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome("test");
		ingrediente.setDescricao("test_dsc");
		ingrediente.setTipoIngrediente(tipoIngrediente);
		
		persist(ingrediente);
		List<Ingrediente> savedIngrediente = findByNome(ingrediente.getNome());
		
		assertNotNull(savedIngrediente);
		assertNotNull(savedIngrediente.get(0));
		assertEquals(savedIngrediente.get(0).getNome(), ingrediente.getNome());
		assertEquals(savedIngrediente.get(0).getDescricao(), ingrediente.getDescricao());
		assertEquals(savedIngrediente.get(0).getTipoIngrediente().getId(), ingrediente.getTipoIngrediente().getId());
	}
	
	private List<Ingrediente> findByNome(String nome) {
		dao.openCurrentSession();
		list.addAll(dao.findByNome(nome));
		dao.closeCurrentSession();
		return list;
	}

	private void persist(Ingrediente ingrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(ingrediente);
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
}
