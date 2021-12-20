package ProgettoPO.ProgettoProgrammazione.entities;

import org.json.simple.JSONObject;

import ProgettoPO.ProgettoProgrammazione.exceptions.MotherEx;

public class CommentError extends CommentMethods {
	
	
	String errore;
	
	String id;
    String message;
	String createdTime;
	String permalinkUrl;
	Boolean canComment;
	Boolean canLike;		
	Boolean userLikes;
	Long commentCount;
	Long likeCount;
	CommentParents parent;
	String from;
	
	public CommentError (JSONObject commento) {};
	
	public void setErrore (MotherEx e) { 
		this.errore = e.getErrore();
	}
	
	public CommentError()
	{
		super();
	}

	
	public String retId(){return null;}
	public String getErrore() {return errore;}
	
}