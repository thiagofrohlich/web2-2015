package br.ufpr.cruel.domain.dao;

import java.util.List;

import br.ufpr.cruel.domain.Pessoa;

public class PessoaDao extends GenericDao<Pessoa, Integer> {

	public PessoaDao() {
		super(Pessoa.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findByNome(String nome) {
		String query = "select p from Pessoa p "
				+ "where p.nome like :nome";
		return (List<Pessoa>) getCurrentSession().createQuery(query).setParameter("nome", nome).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findByTipo(String tipo) {
		String query = "select p from Pessoa p "
				+ "where p.tipoPessoa like :tipoPessoa";
		return (List<Pessoa>) getCurrentSession().createQuery(query).setParameter("tipoPessoa", tipo).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findByCpf(String cpf) {
		String query = "select p from Pessoa p "
				+ "where p.cpf like :cpf";
		return (List<Pessoa>) getCurrentSession().createQuery(query).setParameter("cpf", cpf).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findByCpfOrEmail(String cpf, String email, String tipoPessoa) {
		String query = "select p from Pessoa p "
				+ "where (p.cpf like :cpf "
				+ "or p.email like :email) "
				+ "and p.tipoPessoa = :tipoPessoa ";
		return (List<Pessoa>) getCurrentSession().createQuery(query)
				.setParameter("cpf", cpf)
				.setParameter("email", email)
				.setParameter("tipoPessoa", tipoPessoa).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findByCrn(String crn) {
		String query = "select p from Pessoa p "
				+ "where p.crn like :crn";
		return (List<Pessoa>) getCurrentSession().createQuery(query).setParameter("crn", crn).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findByEmail(String email) {
		String query = "select p from Pessoa p "
				+ "where p.email like :email";
		return (List<Pessoa>) getCurrentSession().createQuery(query).setParameter("email", email).list();
	}
	
	public Pessoa findByEmailAndSenha(String email, String senha) {
		String query = "select p from Pessoa p "
				+ "where p.email = :email "
				+ "and p.senha = :senha";
		return (Pessoa) getCurrentSession().createQuery(query)
				.setParameter("email", email)
				.setParameter("senha", senha).uniqueResult();
	}

}
