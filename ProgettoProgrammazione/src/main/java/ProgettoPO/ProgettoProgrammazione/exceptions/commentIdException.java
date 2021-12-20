package ProgettoPO.ProgettoProgrammazione.exceptions;

public class commentIdException extends MotherEx {
	String errore = "Id del commento non valido";
	
	public commentIdException () {
		super("Id del commento non valido");
	}

	public String getErrore () {return errore;}
}
