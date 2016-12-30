package cl.proyecto.biblioteca.service;

import javax.persistence.EntityManager;

public abstract class JpaDao implements Dao {

	protected EntityManager entityManager;

	protected int defaultPageNumber = 1;

	protected int defaultPageSize = 10;

	public <T> void persist(T entity) {
		entityManager.persist(entity);
	}

	public <T> void remove(T entity) {
		entityManager.remove(entity);
	}

	public <T> void merge(T entity) {
		entityManager.merge(entity);
	}

	public void flush() {
		entityManager.flush();
	}

	public <T, S> T findById(Class<T> clazz, S id) {
		return entityManager.find(clazz, id);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
