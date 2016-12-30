package cl.proyecto.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import cl.proyecto.biblioteca.model.ConsultarLibrosDisponiblesModel;
import cl.proyecto.biblioteca.service.JpaDao;
import cl.proyecto.biblioteca.to.LibroTO;

public class LibroDAO extends JpaDao {

	private Session session;

	public LibroDAO(EntityManager entityManager) {
		super();
		super.setEntityManager(entityManager);
		session = (Session) getEntityManager().getDelegate();
	}

	public ConsultarLibrosDisponiblesModel consultarLibrosDisponibles(String estado) {

		ConsultarLibrosDisponiblesModel resultado = null;

		Query query = session.createSQLQuery("SELECT * FROM libros l WHERE l.estado =: estado").addScalar("idLibro").addScalar("titulo")
				.addScalar("estado").addScalar("cantidad").addScalar("autor").setParameter("estado", estado).setResultTransformer(Transformers.aliasToBean(LibroTO.class));

		@SuppressWarnings("unchecked")
		List<ConsultarLibrosDisponiblesModel> list = query.list();
		if (list != null && list.size() > 0) {
			resultado = (ConsultarLibrosDisponiblesModel) list.get(0);
		} else {
			System.out.println("[consultarSolicitudes] Lista vacía");
		}
		;
		return resultado;

	}

}
