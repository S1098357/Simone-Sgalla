package ProgettoPO.ProgettoProgrammazione.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	public List <Comment> list;
	
	//lista di costruttori
	/*public CommentServiceImpl() {
		list = new ArrayList<>();
		list.add(new Comment (1,"15/10/2001","Ciao Mondo!"));
		//metto in input i commenti dal file Json (ancora da fare)
		
	}
	*/
	
	public JSONObject downloadApi() {
		String url = "https://graph.facebook.com/101440919065369_101911985684929/comments?access_token=EAAcBZAami7SkBAIVM1TD4rqJ5rzZCqWtswD0li0zuv4DfekfR6e4GMEgVlaECg8TWfxpKvp6K3jU1W3rbbC4jS0jfgoFhSGPPmGjZCTMnKPZBZB9Q7fzpny5K0IQtQfUomxlPZCknbGEXcf6m95I3uiLanCFsxZBx3KKHrrw5wI0vTzKHDKOjsLBHFf2UxZBZAZBwZD";
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			
			 String data = "";
			 String line = "";
			 try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			  
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
			   }
			 } finally {
			   in.close();
			 }
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data);	
			return obj;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public JSONObject getComments() {
		return this.downloadApi();
	}
	
	@Override
	public Comment getComment(String id) {
		Comment c = null;
		Comment comment;
		while (!(comment.getId().equals(this.downloadApi().get(id))));
			c = comment;
			return c;
	}

}
