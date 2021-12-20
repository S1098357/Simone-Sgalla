package ProgettoPO.ProgettoProgrammazione.exceptions;

public class MotherEx extends Exception {
	public String errore;
 
	public MotherEx (String errore) {};
	
	public String getErrore() {return errore;}
}
