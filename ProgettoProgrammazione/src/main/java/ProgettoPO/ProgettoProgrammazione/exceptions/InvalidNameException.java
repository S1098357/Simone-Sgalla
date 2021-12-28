package ProgettoPO.ProgettoProgrammazione.exceptions;

public class InvalidNameException extends Exception{
	String errore = "Nome non valido...inserirne un altro" ;
	
	public InvalidNameException () {
		super ("Nome non valido...inserirne un altro");
	}
	
	public String getErrore () {return errore;}
}