package cl.proyecto.biblioteca.service;

public interface Dao {

		public <T> void persist(T entity);

		public <T> void remove(T entity);

		public <T> void merge(T entity);

		public <T, S> T findById(Class<T> clazz, S id);

		public void flush();
	}


