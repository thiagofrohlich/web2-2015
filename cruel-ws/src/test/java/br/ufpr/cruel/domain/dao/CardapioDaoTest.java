package br.ufpr.cruel.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpr.cruel.domain.Cardapio;
import br.ufpr.cruel.domain.Ingrediente;
import br.ufpr.cruel.domain.Refeicao;
import br.ufpr.cruel.domain.TipoIngrediente;

public class CardapioDaoTest {
	
	private TipoIngredienteDao tipoIngredienteDao;
	private IngredienteDao ingredienteDao;
	private RefeicaoDao refeicaoDao;
	private CardapioDao dao;
	private List<Cardapio> list;
	private Refeicao refeicao;
	private SimpleDateFormat dateFormat;

	@Before
	public void setUp() {
		tipoIngredienteDao = new TipoIngredienteDao();
		ingredienteDao = new IngredienteDao();
		refeicaoDao = new RefeicaoDao();
		dao = new CardapioDao();
		list = new ArrayList<Cardapio>();
		refeicao = createRefeicao( createIngrediente( createTipoIngrediente() ) );
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@After
	public void clearTests() {
		dao.openCurrentSessionwithTransaction();
		for(Cardapio tipo : list) {
			dao.delete(tipo);
		}
		dao.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void shouldPersistCardapio() {
		Cardapio cardapio = new Cardapio();
		cardapio.setData(new Date());
		cardapio.setRefeicao1(refeicao);
		cardapio.setRefeicao2(refeicao);
		
		persist(cardapio);
		List<Cardapio> savedCardapio = findByData(cardapio.getData());
		
		assertNotNull(savedCardapio);
		assertNotNull(savedCardapio.get(0));
		assertEquals(dateFormat.format(savedCardapio.get(0).getData()), dateFormat.format(cardapio.getData()));
		assertEquals(savedCardapio.get(0).getRefeicao1().getId(), cardapio.getRefeicao1().getId());
		assertEquals(savedCardapio.get(0).getRefeicao2().getId(), cardapio.getRefeicao2().getId());
	}
	
	private List<Cardapio> findByData(Date data) {
		dao.openCurrentSession();
		list.addAll(dao.findByData(data));
		dao.closeCurrentSession();
		return list;
	}

	private void persist(Cardapio cardapio) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(cardapio);
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
	
	private Refeicao createRefeicao(Ingrediente ingrediente) {
		Refeicao refeicao = new Refeicao();
		refeicao.setTipoRefeicao("test");
		refeicao.setIngrediente1(ingrediente);
		refeicao.setIngrediente2(ingrediente);
		refeicao.setIngrediente3(ingrediente);
		refeicao.setIngrediente4(ingrediente);
		refeicao.setIngrediente5(ingrediente);
		refeicao.setIngrediente6(ingrediente);
		
		refeicaoDao.openCurrentSessionwithTransaction();
		refeicaoDao.persist(refeicao);
		refeicaoDao.getCurrentSession().flush();
		refeicaoDao.getCurrentSession().clear();
		refeicaoDao.getCurrentTransaction().commit();
		refeicaoDao.closeCurrentSession();
		
		return findRefeicaoByNome(refeicao.getTipoRefeicao());
	}
	
	private Refeicao findRefeicaoByNome(String tipoRefeicao) {
		Refeicao refeicao = null;
		refeicaoDao.openCurrentSession();
		refeicao = refeicaoDao.findByTipoRefeicao(tipoRefeicao).get(0);
		refeicaoDao.closeCurrentSession();
		return refeicao;
	}
	
}
