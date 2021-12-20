package ProgettoPO.ProgettoProgrammazione.exceptions;

public class postIdException extends MotherEx{
	
	String errore = "Id del post non valido" ;
	
	public postIdException(){
		super("Id del post non valido");
	};
	
	public String getErrore () {return errore;}
	
	

}
