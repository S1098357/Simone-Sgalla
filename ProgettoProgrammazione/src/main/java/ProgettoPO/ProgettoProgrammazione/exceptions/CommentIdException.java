package ProgettoPO.ProgettoProgrammazione.exceptions;

public class CommentIdException extends MotherEx {
	String errore = "Id del commento non valido";
	
	public CommentIdException () {
		super("Id del commento non valido");
	}

	public String getErrore () {return errore;}
}
