package ProgettoPO.ProgettoProgrammazione.exceptions;

public class InvalidDateException extends Exception {
	
	public String errore = "Non esistono commenti in questa data"; 
	
	public InvalidDateException() {
		super("Non esistono commenti in questa data");
		}

	public String getErrore () {return errore;}
}
