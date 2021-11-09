package br.com.fiap.GlobalSolution.exception;

public class OngNotFoundException extends RuntimeException{
    public OngNotFoundException() {
        super("User not found with");
    }
}
