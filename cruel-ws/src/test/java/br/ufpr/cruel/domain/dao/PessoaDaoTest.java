package br.ufpr.cruel.domain.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpr.cruel.domain.Pessoa;

public class PessoaDaoTest {
	
	private PessoaDao dao;
	private List<Pessoa> list;

	@Before
	public void setUp() {
		dao = new PessoaDao();
		list = new ArrayList<Pessoa>();
	}
	
	@After
	public void clearTests() {
		dao.openCurrentSessionwithTransaction();
		for(Pessoa tipo : list) {
			dao.delete(tipo);
		}
		dao.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void shouldPersistPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("test");
		pessoa.setCpf("12345678910");
		pessoa.setCrn("000000000000");
		pessoa.setEmail("email@email.com");
		pessoa.setEndereco("rua test");
		pessoa.setSenha("test");
		pessoa.setTelefone("4133334444");
		pessoa.setTipoPessoa("Nutricionista");
		
		persist(pessoa);
		List<Pessoa> savedPessoa = findByNome(pessoa.getNome());
		
		assertNotNull(savedPessoa);
		assertNotNull(savedPessoa.get(0));
		assertEquals(savedPessoa.get(0).getNome(), pessoa.getNome());
		assertEquals(savedPessoa.get(0).getCpf(), pessoa.getCpf());
		assertEquals(savedPessoa.get(0).getCrn(), pessoa.getCrn());
		assertEquals(savedPessoa.get(0).getEmail(), pessoa.getEmail());
		assertEquals(savedPessoa.get(0).getEndereco(), pessoa.getEndereco());
		assertEquals(savedPessoa.get(0).getSenha(), pessoa.getSenha());
		assertEquals(savedPessoa.get(0).getTelefone(), pessoa.getTelefone());
		assertEquals(savedPessoa.get(0).getTipoPessoa(), pessoa.getTipoPessoa());
	}
	
	private List<Pessoa> findByNome(String nome) {
		dao.openCurrentSession();
		list.addAll(dao.findByNome(nome));
		dao.closeCurrentSession();
		return list;
	}

	private void persist(Pessoa pessoa) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(pessoa);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
}
