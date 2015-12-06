package br.ufpr.cruel.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpr.cruel.domain.TipoIngrediente;

public class TipoIngredienteDaoTest {
	
	private TipoIngredienteDao dao;
	private List<TipoIngrediente> list;

	@Before
	public void setUp() {
		dao = new TipoIngredienteDao();
		list = new ArrayList<TipoIngrediente>();
	}
	
	@After
	public void clearTests() {
		dao.openCurrentSessionwithTransaction();
		for(TipoIngrediente tipo : list) {
			dao.delete(tipo);
		}
		dao.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void shouldPersistTipoIngrediente() {
		TipoIngrediente tipoIngrediente = new TipoIngrediente();
		tipoIngrediente.setNome("test");
		
		persist(tipoIngrediente);
		List<TipoIngrediente> savedTipoIngrediente = findByNome(tipoIngrediente.getNome());
		
		assertNotNull(savedTipoIngrediente);
		assertNotNull(savedTipoIngrediente.get(0));
		assertEquals(savedTipoIngrediente.get(0).getNome(), tipoIngrediente.getNome());
	}
	
	private TipoIngrediente findById(Integer id) {
		dao.openCurrentSession();
		TipoIngrediente result = dao.findById(id);
		dao.closeCurrentSession();
		list.add(result);
		return result;
	}
	
	private List<TipoIngrediente> findByNome(String nome) {
		dao.openCurrentSession();
		list.addAll(dao.findByNome(nome));
		dao.closeCurrentSession();
		return list;
	}

	private void persist(TipoIngrediente tipoIngrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(tipoIngrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
}
