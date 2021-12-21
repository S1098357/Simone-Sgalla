package ProgettoPO.ProgettoProgrammazione.exceptions;

public class InvalidHour extends MotherEx {
	String errore = "Non esistono commenti a quest'ora";
	
	public InvalidHour () {
		super("Non esistono commenti a quest'ora");
	}

	public String getErrore () {return errore;}
}
