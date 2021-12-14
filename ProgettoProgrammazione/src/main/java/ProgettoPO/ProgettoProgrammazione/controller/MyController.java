package ProgettoPO.ProgettoProgrammazione.controller;


import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.services.CommentService;
import ProgettoPO.ProgettoProgrammazione.services.CommentServiceImpl;

import java.util.List;


@RestController
public class MyController {
	
	@Autowired
	private CommentServiceImpl commentService;

	//riporta tutti i commenti
	@GetMapping("/comments")
	public JSONObject getComments () {
		return this.commentService.getComments();
	}
	
	//riporta un singolo commento tramite id
	@RequestMapping("/comments/{id}")
	public Comment getComment (@PathVariable String id) {
		return this.commentService.getComment(id);  //E' necessaria la conversione in long
		                                                                   //perchè nel Json l'id è di tipo long
	}
	
	
}