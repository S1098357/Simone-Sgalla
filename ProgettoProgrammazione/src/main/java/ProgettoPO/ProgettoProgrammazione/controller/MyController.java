package ProgettoPO.ProgettoProgrammazione.controller;


import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.lang.Exception;

import ProgettoPO.ProgettoProgrammazione.StatsFilters.*;
import ProgettoPO.ProgettoProgrammazione.entities.CommentError;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.services.CommentServiceImpl;
import ProgettoPO.ProgettoProgrammazione.exceptions.*;

import java.util.InputMismatchException;
import java.util.Vector;

/**
 * Classe necessaria al controllo dell'applicazione.
 * Qui sono contenuti i "comandi" per la mappatura delle diverse funzioni nei differenti paths
 */

@RestController
public class MyController {
	
	@Autowired
	private CommentServiceImpl commentService = new CommentServiceImpl();
	private CommentStats stats = new CommentStats();
	private CommentFilters filters = new CommentFilters();
	
	/**
	 * Primo GetMapping: viene lanciata la funzione che restituisce tutti i posts di una determinata pagina
	 * @return la lista dei posts di una determinata pagina
	 */
	
	@GetMapping("/posts")
	public JSONObject getPosts() {
		return this.commentService.getPosts();
	}
	

	/**
	 * Secondo GetMapping: viene lanciata la funzione che restituisce tutti i commenti sotto un determinato post (quello di cui si inserisce l'id)
	 * @see CommentMethods
	 * @param postId PathVariable postId, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path
	 * @return la lista dei commenti sotto un determinato post, di cui si inserisce l'id
	 */
	
	@GetMapping("/posts/{postId}/comments")
	public Vector <CommentMethods> getComments (@PathVariable String postId) {
		return this.commentService.getComments(postId); 
	}
	
	/**
	 * Terzo GetMapping: viene lanciata la funzione che restituisce un singolo commento tramite id, inserito dall'utente
	 * @see CommentMethods
	 * @param id PathVariable id, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path
	 * @return il singolo commento du cui si inserisce l'id
	 */
	
	@GetMapping("/posts/{postId}/comments/{id}")
	public CommentMethods getComment (@PathVariable String id) {
		CommentMethods risposta = this.commentService.getComment(id);
		return risposta;
	}
	
	/**
	 * Quarto GetMapping: viene lanciata la funzione che restituisce tutti i commenti presenti sotto tutti i post della pagina
	 * @see CommentMethods
	 * @return la lista di tutti i commenti
	 */
	
	@GetMapping("/comments")
	public Vector<CommentMethods> getAllComments () {
		return this.commentService.getAllComments();
	}
	
	/**
	 * Quinto GetMapping: vengono lanciate tutte le funzioni relative alle statistiche 
	 * @param name1 PathVariable name1, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path.
	 * Si riferisce al nome dell'utente di cui si vuole calcolare la frequenza.  
	 * @param name2 PathVariable name2, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path.
	 * Si riferisce al nome dell'utente di cui si vuole calcolare il numero di commenti totali nella pagina.
	 * @return la lista con tutte le statistiche indicate
	 */
	
	@GetMapping ("/stats/{name1}/{name2}")
	public Vector<String> getStats (@PathVariable String name1, @PathVariable String name2)  {
		//Vector<String> stats = new Vector <String>();
		Vector <CommentMethods> lista = this.commentService.getAllComments();
		Vector<String> stats = this.stats.frequenzaUtente(lista, name1);
		stats.add("Media dell'orario: "+this.stats.mediaOrario(lista));
		stats.add("Orario massimo: "+this.stats.orarioMax(lista));
	    stats.add("Orario minimo: "+this.stats.orarioMin(lista));
		stats.add("Media  Commenti al giorno. "+this.stats.mediaCommentiAlGiorno(lista));
	    stats.add("Media Like per commento: "+this.stats.mediaLike(lista));
	    stats.add("Media Risposta per commento: " + this.stats.mediaRisposte(lista));
	    stats.add("Numero commenti per utente: " + this.stats.numCommentiUtente(lista, name2));
		return stats;
	}
	
	/**
	 * Sesto GetMapping: vengono lanciate tutte le funzioni relative ai filtri
	 * @see CommentMethods
	 * @param date PathVariable date, ovvero un numero intero variabile (scelto dall'utente) che viene messo nel path.
	 * Indica la data in cui sono stati fatti i commenti.
	 * @param hour PathVariable hour, ovvero un numero intero variabile (scelto dall'utente) che viene messo nel path.
	 * Indica l' orario in cui sono stati fatti i commenti.
	 * @param name PathVariable name, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path.
	 * Indica il nome dell'utente di cui si vogliono sapere i commenti
	 * @return una lista di commenti che si riferiscono ai filtri indicati
	 */
	
	@GetMapping("/filters/{date}/{hour}/{name}")
	public Vector <Vector<CommentMethods>> getFilters (@PathVariable int date,@PathVariable int hour,@PathVariable String name) {
		Vector <CommentMethods> lista = this.commentService.getAllComments();
		Vector <Vector<CommentMethods>> filters = new Vector <Vector <CommentMethods>>(); 
		filters.add(this.filters.filtroGiorni(lista, date));
		filters.add(this.filters.filtroOre(lista, hour));
		filters.add(this.filters.filtroUtenti(lista, name));
		return filters;
	}
	
	/**
	 * Settimo GetMapping: è stato creato per generare un'eccezione personalizzata nel caso in cui l'utente inserisca un path non esistente
	 * @return La stringa contenente l'errore di path non valido
	 */
	
	@GetMapping("/{path}")
	public String Ex() {
		CommentError a = new CommentError();
		a.setErrore(new InvalidPathException());
		return a.getErrore();
	}
	 
}