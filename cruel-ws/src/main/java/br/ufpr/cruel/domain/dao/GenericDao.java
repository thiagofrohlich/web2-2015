package br.ufpr.cruel.domain.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.ufpr.cruel.domain.Atendimento;
import br.ufpr.cruel.domain.Cardapio;
import br.ufpr.cruel.domain.Ingrediente;
import br.ufpr.cruel.domain.Pessoa;
import br.ufpr.cruel.domain.Refeicao;
import br.ufpr.cruel.domain.TipoCliente;
import br.ufpr.cruel.domain.TipoIngrediente;

public abstract class GenericDao<T, ID extends Serializable> implements Dao<T, ID> {
	private final Class<T> clazz;
	private Session currentSession;
	private Transaction currentTransaction;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
    public Session openCurrentSession() {
    	currentSession = getSessionFactory().openSession();
	        return currentSession;
	    }
	    public Session openCurrentSessionwithTransaction() {
	        currentSession = getSessionFactory().openSession();
	        currentTransaction = currentSession.beginTransaction();
	        return currentSession;
	    }
	    public void closeCurrentSession() {
	        currentSession.close();
	    }
	     
	    public void closeCurrentSessionwithTransaction() {
	        currentTransaction.commit();
	        currentSession.close();
	    }
	     
	    private static SessionFactory getSessionFactory() {
	    	Configuration configuration = new Configuration()
	    			.addPackage("br.ufpr.cruel.domain")
	    			.addAnnotatedClass(TipoIngrediente.class)
	    			.addAnnotatedClass(TipoCliente.class)
	    			.addAnnotatedClass(Ingrediente.class)
	    			.addAnnotatedClass(Refeicao.class)
	    			.addAnnotatedClass(Cardapio.class)
	    			.addAnnotatedClass(Pessoa.class)
	    			.addAnnotatedClass(Atendimento.class);
	    	configuration.configure("/hibernate.cfg.xml");
	    	
	    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties());
	        return configuration.buildSessionFactory(builder.build());
	    	
	    }
	 
	    public Session getCurrentSession() {
	        return currentSession;
	    }
	 
	    public void setCurrentSession(Session currentSession) {
	        this.currentSession = currentSession;
	    }
	 
	    public Transaction getCurrentTransaction() {
	        return currentTransaction;
	    }
	 
	    public void setCurrentTransaction(Transaction currentTransaction) {
	        this.currentTransaction = currentTransaction;
	    }
	 
	    /* (non-Javadoc)
		 * @see br.ufpr.cruel.domain.dao.Dao#persist(T)
		 */
	    @Override
		public void persist(T entity) {
	        getCurrentSession().save(entity);
	    }
	 
	    /* (non-Javadoc)
		 * @see br.ufpr.cruel.domain.dao.Dao#update(T)
		 */
	    @Override
		public void update(T entity) {
	        getCurrentSession().update(entity);
	    }
	 
	    /* (non-Javadoc)
		 * @see br.ufpr.cruel.domain.dao.Dao#findById(ID)
		 */
	    @Override
		public T findById(ID id) {
	        T object = (T) getCurrentSession().get(clazz, id);
	        return object;
	    }
	 
	    /* (non-Javadoc)
		 * @see br.ufpr.cruel.domain.dao.Dao#delete(T)
		 */
	    @Override
		public void delete(T entity) {
	        getCurrentSession().delete(entity);
	    }
	 
	    /* (non-Javadoc)
		 * @see br.ufpr.cruel.domain.dao.Dao#findAll()
		 */
	    @Override
		@SuppressWarnings("unchecked")
	    public List<T> findAll() {
	        List<T> objects = (List<T>) getCurrentSession().createQuery("from "+ clazz.getName()).list();
	        return objects;
	    }
	 
	    /* (non-Javadoc)
		 * @see br.ufpr.cruel.domain.dao.Dao#deleteAll()
		 */
	    @Override
		public void deleteAll() {
	        List<T> entityList = findAll();
	        for (T entity : entityList) {
	            delete(entity);
	        }
	    }
}
