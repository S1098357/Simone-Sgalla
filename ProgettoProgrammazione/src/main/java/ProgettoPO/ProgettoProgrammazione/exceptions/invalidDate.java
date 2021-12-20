package ProgettoPO.ProgettoProgrammazione.exceptions;

public class invalidDate extends MotherEx {
	
	public String errore = "Non esistono commenti in questa data"; 
	
	public invalidDate() {
		super("Non esistono commenti in questa data");
		}

	public String getErrore () {return errore;}
}
