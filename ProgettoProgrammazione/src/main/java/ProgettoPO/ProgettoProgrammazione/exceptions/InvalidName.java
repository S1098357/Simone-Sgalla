package ProgettoPO.ProgettoProgrammazione.exceptions;

public class InvalidName extends Exception{
	String errore = "Nome non valido...inserirne un altro" ;
	
	public InvalidName () {
		super ("Nome non valido...inserirne un altro");
	}
	
	public String getErrore () {return errore;}
}