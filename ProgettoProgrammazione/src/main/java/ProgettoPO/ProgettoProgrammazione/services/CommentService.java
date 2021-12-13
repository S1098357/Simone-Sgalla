package ProgettoPO.ProgettoProgrammazione.services;

import java.util.List;
import ProgettoPO.ProgettoProgrammazione.entities.Comment;

public interface CommentService {

	public List<Comment> getComments();
	public Comment getComment(long commentId);

}
