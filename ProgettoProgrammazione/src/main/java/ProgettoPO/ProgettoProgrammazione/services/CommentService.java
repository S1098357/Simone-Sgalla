package ProgettoPO.ProgettoProgrammazione.services;


import java.util.Vector;

import org.json.simple.JSONObject;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.entities.CommentError;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.exceptions.CommentIdException;
import ProgettoPO.ProgettoProgrammazione.exceptions.PostIdException;

public interface CommentService {

	public Vector <CommentMethods> getComments(String postId) throws PostIdException ;
	public CommentMethods getComment(String commentId) throws CommentIdException;
	public JSONObject getPosts();
	public Vector<CommentMethods> getAllComments() throws PostIdException;
}