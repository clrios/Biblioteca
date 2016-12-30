package cl.proyecto.biblioteca.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cl.proyecto.biblioteca.dao.LibroDAO;
import cl.proyecto.biblioteca.excepcion.ServiceException;
import cl.proyecto.biblioteca.model.ConsultarLibrosDisponiblesModel;
import cl.proyecto.biblioteca.to.LibroTO;

@Stateless
@LocalBean
public class LibroBean {

	@PersistenceContext(unitName = "biblioteca")
	private EntityManager entityManager;

	private LibroBean() {

	}

	public LibroTO getLibrosDisponibles(String estado) throws ServiceException {

		LibroTO libroTO = new LibroTO();

		try {
			LibroDAO libroDAO = new LibroDAO(entityManager);

			ConsultarLibrosDisponiblesModel consultarLibrosDisponiblesModel = libroDAO.consultarLibrosDisponibles(estado);
			libroTO.setIdLibro(consultarLibrosDisponiblesModel.getIdLibro());
			libroTO.setTitulo(consultarLibrosDisponiblesModel.getTitulo());
			libroTO.setEstado(consultarLibrosDisponiblesModel.getEstado());
			libroTO.setCantidad(consultarLibrosDisponiblesModel.getCantidad());
			libroTO.setAutor(consultarLibrosDisponiblesModel.getAutor());
		} catch (Exception e) {
			throw new ServiceException("Error al obtener datos de libro");
		}
		return libroTO;

	}

}
