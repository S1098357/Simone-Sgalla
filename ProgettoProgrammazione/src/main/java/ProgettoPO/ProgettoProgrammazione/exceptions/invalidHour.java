package ProgettoPO.ProgettoProgrammazione.exceptions;

public class invalidHour extends MotherEx {
	String errore = "Non esistono commenti a quest'ora";
	
	public invalidHour () {
		super("Non esistono commenti a quest'ora");
	}

	public String getErrore () {return errore;}
}
