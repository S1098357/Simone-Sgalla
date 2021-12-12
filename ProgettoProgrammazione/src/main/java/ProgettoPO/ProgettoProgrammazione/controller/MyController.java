package ProgettoPO.ProgettoProgrammazione.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import java.util.List;


@RestController
public class MyController {

	@GetMapping("/home")
	public String Comments () {
		return "Questi sono i commenti della pagina Programmazione Oggetti";
	}
	
	//riporta tutti i commenti
	@GetMapping("/comments")
	public List<Comment> getComments () {
	
	
	
}
	
}