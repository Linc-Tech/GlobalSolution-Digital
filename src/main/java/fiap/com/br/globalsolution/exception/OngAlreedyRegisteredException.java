package fiap.com.br.globalsolution.exception;

public class OngAlreedyRegisteredException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OngAlreedyRegisteredException(String message) {
		super(message);
	}
}
