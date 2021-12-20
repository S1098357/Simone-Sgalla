package ProgettoPO.ProgettoProgrammazione.exceptions;

public class invalidName extends MotherEx{
	String errore = "Nome non valido...inserirne un altro" ;
	
	public invalidName () {
		super ("Nome non valido...inserirne un altro");
	}
	
	public String getErrore () {return errore;}
}