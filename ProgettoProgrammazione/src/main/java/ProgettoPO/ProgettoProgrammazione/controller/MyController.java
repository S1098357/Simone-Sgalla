package ProgettoPO.ProgettoProgrammazione.controller;


import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.services.CommentServiceImpl;
import ProgettoPO.ProgettoProgrammazione.stats.commentStats;
import ProgettoPO.ProgettoProgrammazione.exceptions.postIdException;

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
	public Vector <Comment> getComments (@PathVariable String postId) throws postIdException {
		JSONArray prova = (JSONArray) this.commentService.getPosts().get("data");
		for (int i = 0; i<prova.size(); i++) {
		JSONObject obj = (JSONObject) prova.get(i);
		String id = (String) obj.get("id");
		if (id.equals(postId)) return this.commentService.getComments(postId);
		}
		throw new postIdException();
		//return this.commentService.getComments(postId); 
	}
	
	//riporta un singolo commento tramite id
	@GetMapping("/posts/{postId}/comments/{id}")
	public Comment getComment (@PathVariable String id) {
		Comment risposta = this.commentService.getComment(id);
		return risposta;
	}
	
	@GetMapping("/comments")
	public Vector<Comment> getAllComments () {
		return this.commentService.getAllComments();
	}
	
	
	@GetMapping("/stats")
	public Vector<String> getStats () {
		//Vector<String> stats = new Vector <String>();
		Vector <Comment> lista = this.commentService.getAllComments();
		Vector<String> stats = this.stats.frequenzaUtente(lista, "Andrea Marini");
		stats.add("Media dell'orario: "+this.stats.mediaOrario(lista));
		stats.add("Orario massimo: "+this.stats.orarioMax(lista));
	    stats.add("Orario minimo: "+this.stats.orarioMin(lista));
		stats.add("Media  Commenti al giorno. "+this.stats.mediaCommentiAlGiorno(lista));
	    stats.add("Media Like per commento: "+this.stats.mediaLike(lista));
	    stats.add("Media Risposta per commento: " + this.stats.mediaRisposte(lista));
	    stats.add("Numero commenti per utente: " + this.stats.numCommentiUtente(lista, "Andrea Marini"));
		return stats;
	}
	
	@GetMapping("/filters")
	public Vector <Vector<Comment>> getFilters () {
		Vector <Comment> lista = this.commentService.getAllComments();
		Vector <Vector<Comment>> filters = new Vector <Vector <Comment>>(); 
		filters.add(this.stats.filtroGiorni(lista, 16));
		filters.add(this.stats.filtroOre(lista, 23));
		filters.add(this.stats.filtroUtenti(lista, "Andrea Marini"));
		return filters;
	}
	 
}