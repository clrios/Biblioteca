package cl.proyecto.biblioteca.excepcion;

public enum HttpCodes {
	BAD_REQUEST(400),
	UNAUTHORIZED(401),
	FORBIDDEN(403),
	AUTHENTICATION_TIMEOUT(419),
	INTERNAL_SERVER_ERROR(500);

	private HttpCodes(int codigo) {
		this.codigo = codigo;
	}

	private int codigo;

	public int getCodigo() {
		return this.codigo;
	}

}
