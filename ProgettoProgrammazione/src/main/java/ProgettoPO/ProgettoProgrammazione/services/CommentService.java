package ProgettoPO.ProgettoProgrammazione.services;


import java.util.Vector;

import org.json.simple.JSONObject;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.entities.CommentError;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.exceptions.commentIdException;
import ProgettoPO.ProgettoProgrammazione.exceptions.postIdException;

public interface CommentService {

	public Vector <CommentMethods> getComments(String postId) throws postIdException ;
	public CommentMethods getComment(String commentId) throws commentIdException;
	public JSONObject getPosts();
	public Vector<CommentMethods> getAllComments() throws postIdException;
}