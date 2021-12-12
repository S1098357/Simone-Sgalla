package ProgettoPO.ProgettoProgrammazione.services;

import java.util.ArrayList;
import java.util.List;
import ProgettoPO.ProgettoProgrammazione.entities.Comment;

public class CommentServiceImpl implements CommentService {

	public List <Comment> list;
	
	//lista di costruttori
	public CommentServiceImpl() {
		list = new ArrayList<>();
		//metto in input i commenti dal file Json (ancora da fare)
		
	}
	
	
	@Override
	public List<Comment> getComments() {
		
		return null;
	}

}
