package ProgettoPO.ProgettoProgrammazione.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	public Vector <Comment> listaCommenti=new Vector<Comment>(); 
	
	
	public JSONObject downloadApi(String url) {
		try {
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			
			 String data = "";
			 String line = "";
			 try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			  
			   while (( line = buf.readLine()) != null ) {
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
	public JSONObject getPosts() {
		return this.downloadApi("https://graph.facebook.com/me?fields=posts&access_token=EAAcBZAami7SkBAK56LhkerKwk4FHQmgpZC7urTtM4EsxdRhtS0Fo2qisPPBGNlVA5osPmXquRxgZC1ETdM3rN6V1tQFAO16qtMsdlxtrIcUWsDwGZAuw8NcWi8lY3q6vb5WIjDs3sZBpoh9V077WI4KW2Mr1ZBHJWMs3Il4zBHFQaJTA6oQjfZCqfahvlfqiGcZD");
		}
	
	
	@Override
	public  Vector <Comment> getComments(String postId) {
		String preUrl="https://graph.facebook.com/";
		String id;
		String postUrl="?fields=parent,id,message,from,created_time,permalink_url,can_comment,can_like,user_likes,comment_count,like_count&access_token=EAAcBZAami7SkBAK56LhkerKwk4FHQmgpZC7urTtM4EsxdRhtS0Fo2qisPPBGNlVA5osPmXquRxgZC1ETdM3rN6V1tQFAO16qtMsdlxtrIcUWsDwGZAuw8NcWi8lY3q6vb5WIjDs3sZBpoh9V077WI4KW2Mr1ZBHJWMs3Il4zBHFQaJTA6oQjfZCqfahvlfqiGcZD";
		String postPostUrl="/comments?access_token=EAAcBZAami7SkBAK56LhkerKwk4FHQmgpZC7urTtM4EsxdRhtS0Fo2qisPPBGNlVA5osPmXquRxgZC1ETdM3rN6V1tQFAO16qtMsdlxtrIcUWsDwGZAuw8NcWi8lY3q6vb5WIjDs3sZBpoh9V077WI4KW2Mr1ZBHJWMs3Il4zBHFQaJTA6oQjfZCqfahvlfqiGcZD";
		JSONObject prova=this.downloadApi(preUrl+postId+postPostUrl);
		JSONArray obj=(JSONArray)prova.get("data");
		for(int i=0;i<obj.size();i++)
		{
		prova=(JSONObject) obj.get(i);
		id=(String)prova.get("id");
		JSONObject commento=this.downloadApi(preUrl+id+postUrl);
		this.listaCommenti.add(new Comment(commento));
		id=(String)commento.get("id");
		commento=this.downloadApi(preUrl+id+postPostUrl);
		if(commento.get("data")!=null)
			{
			JSONArray risposte= (JSONArray) commento.get("data");
				for(int j=0;j<risposte.size();j++)
				{
					commento=(JSONObject)risposte.get(j);
					id=(String) commento.get("id");
					this.listaCommenti.add(new Comment(this.downloadApi(preUrl+id+postUrl)));
				}
			}
		
		}
		return listaCommenti;
	}
	
	
	@Override
	public Comment getComment(String id) {
		for (int i=0;i<listaCommenti.size();i++)
		{
			if(id.equals(listaCommenti.get(i).getId()))
			{
				return listaCommenti.get(i);
			}
		}
		return null;
	}

	
	public Vector<Comment> getAllComments () {
		this.listaCommenti.clear();
		String id;
		JSONObject prova=this.downloadApi("https://graph.facebook.com/101440919065369/posts?access_token=EAAcBZAami7SkBAK56LhkerKwk4FHQmgpZC7urTtM4EsxdRhtS0Fo2qisPPBGNlVA5osPmXquRxgZC1ETdM3rN6V1tQFAO16qtMsdlxtrIcUWsDwGZAuw8NcWi8lY3q6vb5WIjDs3sZBpoh9V077WI4KW2Mr1ZBHJWMs3Il4zBHFQaJTA6oQjfZCqfahvlfqiGcZD");
		JSONArray obj=(JSONArray)prova.get("data");
		for(int i=0;i<obj.size();i++)
		{
		prova=(JSONObject) obj.get(i);
		id=(String)prova.get("id");
		this.getComments(id);
		}
	return this.listaCommenti;
	}
		
		
	}




