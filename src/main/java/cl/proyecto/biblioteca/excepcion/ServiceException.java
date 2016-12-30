package cl.proyecto.biblioteca.excepcion;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private int codigoHttp;

	private String mensaje;

	public ServiceException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}

	public ServiceException(String mensaje, Throwable causa) {
		super(mensaje, causa);
		this.mensaje = mensaje;
	}

	public ServiceException(int codigoHttp, String mensaje) {
		super(mensaje);
		this.codigoHttp = codigoHttp;
		this.mensaje = mensaje;
	}

	public ServiceException(int codigoHttp, String mensaje, Throwable causa) {
		super(mensaje, causa);
		this.codigoHttp = codigoHttp;
		this.mensaje = mensaje;
	}

	public int getCodigoHttp() {
		return codigoHttp;
	}

	public void setCodigoHttp(int codigoHttp) {
		this.codigoHttp = codigoHttp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
