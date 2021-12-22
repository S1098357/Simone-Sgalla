package ProgettoPO.ProgettoProgrammazione.entities;

import org.json.simple.JSONObject;

import ProgettoPO.ProgettoProgrammazione.exceptions.MotherEx;

/**
 * Altra classe figlia di CommentMethods. Serve per realizzare il commento con messaggio di errore nel caso di eccezioni
 */

public class CommentError extends CommentMethods {
	
	//Unico Attributo della classe
	public String errore;
	
	/*String id;
    String message;
	String createdTime;
	String permalinkUrl;
	Boolean canComment;
	Boolean canLike;		
	Boolean userLikes;
	Long commentCount;
	Long likeCount;
	CommentParents parent;
	String from;
	*/
	public CommentError (JSONObject commento) {};
	
	/**
	 * Metodo set della classe CommentError. Ogni classe di eccezione, tutte figlie di MotherEx, ha una stringa personalizzata
	 * che ne indica l'errore. Con questo metodo viene assegnata la stringa di errore all'attributo di CommenError  
	 * @param e MotherEx e. Classe figlia di Exception creata da noi. E' la classe da cui derivano tutte le eccezioni personalizzate
	 */
	
	public void setErrore (MotherEx e) { 
		this.errore = e.getErrore();
	}
	
	public CommentError()
	{
		super();
	}

	//Metodi get e ret di CommentError. Come al solito il metodo ret serve per non far visualizzare a schermo la scritta null, per 
	//la gestione dell'eccezione personalizzata
	public String retId(){return null;}
	public String getErrore() {return errore;}
	
}