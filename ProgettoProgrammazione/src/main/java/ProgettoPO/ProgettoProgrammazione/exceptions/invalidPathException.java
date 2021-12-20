package ProgettoPO.ProgettoProgrammazione.exceptions;

public class invalidPathException extends MotherEx {
	String errore = "Path non esistente" ;
	
	public invalidPathException () {
		super("Path non esistente");
	}
	
	public String getErrore () {return errore;}
}
