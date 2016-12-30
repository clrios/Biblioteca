package cl.proyecto.biblioteca.webservice;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cl.proyecto.biblioteca.bean.LibroBean;
import cl.proyecto.biblioteca.excepcion.HttpCodes;
import cl.proyecto.biblioteca.excepcion.ServiceException;
import cl.proyecto.biblioteca.to.LibroTO;

@Path("/biblioteca")
public class BibliotecaService {

	@EJB
	private LibroBean libroBean;
	
	public BibliotecaService() {
	}

	// @GET
	// @Path("/{pathParameter}")
	// public Response responseMsg(@PathParam("pathParameter") String
	// pathParameter,
	// @DefaultValue("Nothing to say") @QueryParam("queryParameter") String
	// queryParameter) {
	// String response = "Hello from: " + pathParameter + " : " +
	// queryParameter;
	// return Response.status(200).entity(response).build();
	// }

	@GET
	@Path("/librosDisponibles")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public LibroTO getLibrosDisponibles(@HeaderParam("estado") String estado) throws ServiceException {

		LibroTO libroTO = new LibroTO();

		try {
			libroTO = libroBean.getLibrosDisponibles(estado);
		} catch (ServiceException e) {
			throw new ServiceException(HttpCodes.INTERNAL_SERVER_ERROR.getCodigo(), e.getMensaje(), e.getCause());
		}
		return libroTO;

	}

}
