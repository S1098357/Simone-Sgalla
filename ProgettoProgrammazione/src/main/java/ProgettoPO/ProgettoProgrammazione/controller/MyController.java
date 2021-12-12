package ProgettoPO.ProgettoProgrammazione.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;


import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.services.CommentService;
import java.util.List;


@RestController
public class MyController {

	@Autowired
	private CommentService commentService;
	
	//riporta tutti i commenti
	@GetMapping("/comments")
	public List<Comment> getComments () {
	
	
	
}
	
}
