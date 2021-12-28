package ProgettoPO.ProgettoProgrammazione.exceptions;

public class InvalidHourException extends Exception{
	String errore = "Non esistono commenti a quest'ora";
	
	public InvalidHourException () {
		super("Non esistono commenti a quest'ora");
	}

	public String getErrore () {return errore;}
}
