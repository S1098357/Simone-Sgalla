package ProgettoPO.ProgettoProgrammazione.controller;


import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.lang.Exception;

import ProgettoPO.ProgettoProgrammazione.StatsFilters.*;
import ProgettoPO.ProgettoProgrammazione.entities.Comment;
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
	 * @throws PostIdException se l'id inserito non è corretto
	 */
	
	@GetMapping("/posts/{postId}/comments")
	public ResponseEntity <Object> getComments (@PathVariable String postId) {
		commentService.listaCommenti.clear();
		try {
			return new ResponseEntity<>(this.commentService.getComments(postId), HttpStatus.OK);
		} catch (PostIdException e) {
			return new ResponseEntity<> (e.getErrore(), HttpStatus.BAD_REQUEST);
		}
		} 
	
		
	/**
	 * Terzo GetMapping: viene lanciata la funzione che restituisce un singolo commento tramite id, inserito dall'utente
	 * @see CommentMethods
	 * @param id PathVariable id, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path
	 * @return il singolo commento di cui si inserisce l'id
	 * @throws CommentIdException se l'id inserito non è corretto
	 */
	
	@GetMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<Object> getComment (@PathVariable String id) {
		try {
			return new ResponseEntity<> (this.commentService.getComment(id), HttpStatus.OK);
		} catch (CommentIdException e) {
			return new ResponseEntity<> (e.getErrore(), HttpStatus.BAD_REQUEST);
		}
	
	}
	
	/**
	 * Quarto GetMapping: viene lanciata la funzione che restituisce tutti i commenti presenti sotto tutti i post della pagina
	 * @see CommentMethods
	 * @return la lista di tutti i commenti
	 * @throws PostIdException 
	 */
	
	@GetMapping("/comments")
	public Vector<Comment> getAllComments () throws PostIdException {
		return this.commentService.getAllComments();
	}
	
	/**
	 * Quinto GetMapping: vengono lanciate tutte le funzioni relative alle statistiche 
	 * @param name1 PathVariable name1, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path.
	 * Si riferisce al nome dell'utente di cui si vuole calcolare la frequenza.  
	 * @param name2 PathVariable name2, ovvero una stringa variabile (scelta dall'utente) che viene messa nel path.
	 * Si riferisce al nome dell'utente di cui si vuole calcolare il numero di commenti totali nella pagina.
	 * @return la lista con tutte le statistiche indicate
	 * @throws PostIdException
	 */
	
	@GetMapping ("/stats/{name1}/{name2}")
	public ResponseEntity<Object> getStats (@PathVariable String name1, @PathVariable String name2) throws PostIdException  {
		try {
			Vector <Comment> lista = this.commentService.getAllComments();
			Vector<String> stats = this.stats.frequenzaUtente(lista, name1);
			stats.add("Media dell'orario: "+this.stats.mediaOrario(lista));
			stats.add("Orario massimo: "+this.stats.orarioMax(lista));
			stats.add("Orario minimo: "+this.stats.orarioMin(lista));
			stats.add("Media  Commenti al giorno. "+this.stats.mediaCommentiAlGiorno(lista));
			stats.add("Media Like per commento: "+this.stats.mediaLike(lista));
			stats.add("Media Risposta per commento: " + this.stats.mediaRisposte(lista));
			stats.add("Numero commenti per utente: " + this.stats.numCommentiUtente(lista, name2));
			return new ResponseEntity<> (stats,HttpStatus.OK);
		} catch (InvalidNameException e) {
			return new ResponseEntity<> (e.getErrore(), HttpStatus.BAD_REQUEST);
		}
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
	 * @throws PostIdException 
	 * @throws InvalidDateException se la data inserita non è corretta
	 */
	
	@GetMapping("/filters/{date}/{hour}/{name}")
	public ResponseEntity<Object> getFilters (@PathVariable int date,@PathVariable int hour,@PathVariable String name) throws PostIdException, InvalidDateException {
		Vector <Comment> lista = this.commentService.getAllComments();
		Vector <Vector<Comment>> filters = new Vector <Vector <Comment>>(); 
		try {
			filters.add(this.filters.filtroGiorni(lista, date));
		} catch (InvalidDateException a) {
			return new ResponseEntity<>(a.getErrore(),HttpStatus.BAD_REQUEST);
		}
		try {
			filters.add(this.filters.filtroOre(lista, hour));
		} catch (InvalidHourException a) {
			return new ResponseEntity<>(a.getErrore(),HttpStatus.BAD_REQUEST);
		}
		try {
			filters.add(this.filters.filtroUtenti(lista, name));
		} catch (InvalidNameException a) {
			return new ResponseEntity<>(a.getErrore(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<> (filters, HttpStatus.OK);
	}
	
	/**
	 * Settimo GetMapping: è stato creato per generare un'eccezione personalizzata nel caso in cui l'utente inserisca un path non esistente
	 * @return La stringa contenente l'errore di path non valido
	 */
	
	@GetMapping("/{path}")
	public ResponseEntity<Object> Ex() throws InvalidPathException {
		try {
			throw new InvalidPathException();
		} catch (InvalidPathException e) {
			return new ResponseEntity<> (e.getErrore(), HttpStatus.BAD_REQUEST);
		}
	}
	 
}