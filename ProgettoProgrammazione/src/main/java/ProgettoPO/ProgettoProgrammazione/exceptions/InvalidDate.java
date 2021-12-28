package ProgettoPO.ProgettoProgrammazione.exceptions;

public class InvalidDate extends Exception {
	
	public String errore = "Non esistono commenti in questa data"; 
	
	public InvalidDate() {
		super("Non esistono commenti in questa data");
		}

	public String getErrore () {return errore;}
}
