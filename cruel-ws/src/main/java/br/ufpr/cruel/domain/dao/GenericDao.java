package br.ufpr.cruel.domain.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
	        Configuration configuration = new Configuration().configure();
	        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties());
	        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
	        return sessionFactory;
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
		@SuppressWarnings("unchecked")
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
	        List<T> objects = (List<T>) getCurrentSession().createQuery("from "+ clazz.getSimpleName()).list();
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
