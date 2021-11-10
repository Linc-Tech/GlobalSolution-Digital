package br.com.fiap.GlobalSolution.exception;

public class OngNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public OngNotFoundException(String message) {
		super(message);
	}
	
    public OngNotFoundException() {
        super("User not found with");
    }
}
