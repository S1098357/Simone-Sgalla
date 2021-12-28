package ProgettoPO.ProgettoProgrammazione.exceptions;

public class InvalidPathException extends Exception {
	String errore = "Path non esistente" ;
	
	public InvalidPathException () {
		super("Path non esistente");
	}
	
	public String getErrore () {return errore;}
}
