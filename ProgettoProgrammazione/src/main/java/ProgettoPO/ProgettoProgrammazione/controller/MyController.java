package ProgettoPO.ProgettoProgrammazione.controller;


import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.entities.CommentError;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.services.CommentServiceImpl;
import ProgettoPO.ProgettoProgrammazione.stats.commentStats;
import ProgettoPO.ProgettoProgrammazione.exceptions.*;

import java.util.Vector;


@RestController
public class MyController {
	
	@Autowired
	private CommentServiceImpl commentService = new CommentServiceImpl();
	private commentStats stats = new commentStats();
	
	//riporta tutti i post della pagina
	@GetMapping("/posts")
	public JSONObject getPosts() {
		return this.commentService.getPosts();
	}
	

	//riporta tutti i commenti
	@GetMapping("/posts/{postId}/comments")
	public Vector <CommentMethods> getComments (@PathVariable String postId) throws postIdException {
		return this.commentService.getComments(postId); 
	}
	
	//riporta un singolo commento tramite id
	@GetMapping("/posts/{postId}/comments/{id}")
	public CommentMethods getComment (@PathVariable String id) throws commentIdException {
		CommentMethods risposta = this.commentService.getComment(id);
		return risposta;
	}
	
	@GetMapping("/comments")
	public Vector<CommentMethods> getAllComments () throws postIdException {
		return this.commentService.getAllComments();
	}
	
	
	/*@GetMapping("/stats")
	public Vector<String> getStats ()  {
		//Vector<String> stats = new Vector <String>();
		Vector <CommentMethods> lista = this.commentService.getAllComments();
		Vector<String> stats = this.stats.frequenzaUtente(lista, "Andrea Marini");
		stats.add("Media dell'orario: "+this.stats.mediaOrario(lista));
		stats.add("Orario massimo: "+this.stats.orarioMax(lista));
	    stats.add("Orario minimo: "+this.stats.orarioMin(lista));
		stats.add("Media  Commenti al giorno. "+this.stats.mediaCommentiAlGiorno(lista));
	    stats.add("Media Like per commento: "+this.stats.mediaLike(lista));
	    stats.add("Media Risposta per commento: " + this.stats.mediaRisposte(lista));
	    stats.add("Numero commenti per utente: " + this.stats.numCommentiUtente(lista, "Andrea Marini"));
		return stats;
	}*/
	
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
	
	/*@GetMapping("/filters")
	public Vector <Vector<CommentMethods>> getFilters () {
		Vector <CommentMethods> lista = this.commentService.getAllComments();
		Vector <Vector<CommentMethods>> filters = new Vector <Vector <CommentMethods>>(); 
		filters.add(this.stats.filtroGiorni(lista, 11));
		filters.add(this.stats.filtroOre(lista, 23));
		filters.add(this.stats.filtroUtenti(lista, "Andrea Marini"));
		return filters;
	}*/
	
	@GetMapping("/filters/{date}/{hour}/{name}")
	public Vector <Vector<CommentMethods>> getFilters (@PathVariable int date,@PathVariable int hour,@PathVariable String name) {
		Vector <CommentMethods> lista = this.commentService.getAllComments();
		Vector <Vector<CommentMethods>> filters = new Vector <Vector <CommentMethods>>(); 
		filters.add(this.stats.filtroGiorni(lista, date));
		filters.add(this.stats.filtroOre(lista, hour));
		filters.add(this.stats.filtroUtenti(lista, name));
		return filters;
	}
	
	@GetMapping("/{path}")
	public String Ex() {
		CommentError a = new CommentError();
		a.setErrore(new invalidPathException());
		return a.getErrore();
	}
	 
}