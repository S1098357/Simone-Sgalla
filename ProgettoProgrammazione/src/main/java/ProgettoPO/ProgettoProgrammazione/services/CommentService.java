package ProgettoPO.ProgettoProgrammazione.services;

import org.json.simple.JSONObject;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;

public interface CommentService {

	public JSONObject getComments() ;
	public Comment getComment(long commentId);

}