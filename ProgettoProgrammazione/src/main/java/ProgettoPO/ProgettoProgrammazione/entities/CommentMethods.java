package ProgettoPO.ProgettoProgrammazione.entities;

import org.json.simple.JSONObject;
/**
 * Classe madre dei commenti. Nasce dalla necessità di creare una classe dedicata ai commenti esistenti (Comment) con tutti 
 * gli attributi di un commento e una classe necessaria per la creazione di eccezioni personalizzate (CommentError). Quest'ultima 
 * serve per generare un commento, nel caso di un qualche errore dovuto all'utente, che abbia un solo messaggio di errore,
 * che varierà a seconda del tipo di eccezione lanciata.
 */

public class CommentMethods {

/**
 * Costruttore vuoto della classe madre. Verrà poi ridefinito nelle classi figlie
 * @param commento E' di tipo JSONObject in quanto i dati di ogni commento vengono presi sotto forma di dato Json
 */
	public CommentMethods(JSONObject commento ) {}
	public CommentMethods() {};
	/**
	 * Sono necessari per la riuscita del programma, in quanto abbiamo ritenuto necessario far visualizzare all'utente 
	 * un campo solo di errore nel caso di un'eccezione. Se avessimo messo get al posto di ret, nel Json file si sarebbero 
	 * visualizzati tutti i campi di un commento nulli e non solo quello di errore.
	 * @return null
	 */
	public String retId() {return null;}
	public String retCreatedTime() {return null;}
	public String retFrom() {return null;}
	public Long retLikeCount() {return null;}
	public Long retCommentCount() {return null;}
	
}