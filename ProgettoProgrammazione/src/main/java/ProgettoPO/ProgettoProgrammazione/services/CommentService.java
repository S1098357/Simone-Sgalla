package ProgettoPO.ProgettoProgrammazione.services;


import java.util.Vector;

import org.json.simple.JSONObject;
import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.exceptions.CommentIdException;
import ProgettoPO.ProgettoProgrammazione.exceptions.PostIdException;
/**
 * Interfaccia che contiene tutti i metodi relativi a tutte le operazioni (Servizi) che possono essere svolte dal programma
 * escludendo le statistiche e i filtri
 */
public interface CommentService {

	//Metodi
	public Vector<Comment> getComments(String postId) throws PostIdException ;
	public Comment getComment(String commentId) throws CommentIdException ;
	public JSONObject getPosts();
	public Vector<Comment> getAllComments() throws PostIdException;
}