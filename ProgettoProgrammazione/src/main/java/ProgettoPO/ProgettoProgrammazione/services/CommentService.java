package ProgettoPO.ProgettoProgrammazione.services;

import java.util.List;
import java.util.Vector;

import org.json.simple.JSONObject;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;

public interface CommentService {

	public Vector <Comment> getComments(String postId) ;
	public Comment getComment(String commentId);
	public JSONObject getPosts();
	public Vector<Comment> getAllComments();
}