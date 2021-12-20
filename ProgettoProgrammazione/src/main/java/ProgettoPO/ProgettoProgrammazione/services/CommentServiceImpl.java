package ProgettoPO.ProgettoProgrammazione.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.entities.CommentError;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.exceptions.*;

@Service
public class CommentServiceImpl implements CommentService {
	public Vector <CommentMethods> listaCommenti=new Vector<CommentMethods>(); 
	
	
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
			//e.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public JSONObject getPosts() {
		return this.downloadApi("https://graph.facebook.com/me?fields=posts&access_token=EAAcBZAami7SkBALEEiq8kksXCZCOaDnDRg15d75XAmo2yKHfMgBojWDhaVatR6zAndCgveSvIAHZA6YTAO87vZCGOKTh2N8tWqc6oZBaT5r1Oes15P6I1UuAoCWSqDI5hi4RTKCoG3zzAIUIrlLdPIAjIbo4rsSHXJZBGhiQmYUBHoExMEgjdxYsepxWDDPMsZD");
		}
	
	
	@Override
	public  Vector <CommentMethods> getComments(String postId) {
		JSONObject prova=null;
		String preUrl="https://graph.facebook.com/";
		String id;
		String postUrl="?fields=parent,id,message,from,created_time,permalink_url,can_comment,can_like,user_likes,comment_count,like_count&access_token=EAAcBZAami7SkBALEEiq8kksXCZCOaDnDRg15d75XAmo2yKHfMgBojWDhaVatR6zAndCgveSvIAHZA6YTAO87vZCGOKTh2N8tWqc6oZBaT5r1Oes15P6I1UuAoCWSqDI5hi4RTKCoG3zzAIUIrlLdPIAjIbo4rsSHXJZBGhiQmYUBHoExMEgjdxYsepxWDDPMsZD";
		String postPostUrl="/comments?access_token=EAAcBZAami7SkBALEEiq8kksXCZCOaDnDRg15d75XAmo2yKHfMgBojWDhaVatR6zAndCgveSvIAHZA6YTAO87vZCGOKTh2N8tWqc6oZBaT5r1Oes15P6I1UuAoCWSqDI5hi4RTKCoG3zzAIUIrlLdPIAjIbo4rsSHXJZBGhiQmYUBHoExMEgjdxYsepxWDDPMsZD";
		try {
		prova=this.downloadApi(preUrl+postId+postPostUrl);
		if (prova==null) throw new postIdException();
		} catch (Exception e) {
			CommentError a = new CommentError();
			a.setErrore(new postIdException());
			listaCommenti.add(a);
		  return listaCommenti;
		}
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
	public CommentMethods getComment(String id)  {
		for (int i=0;i<listaCommenti.size();i++)
		{
			if(id.equals(listaCommenti.get(i).retId()))
			{
				return listaCommenti.get(i);
			}
		}
		CommentError a = new CommentError();
		a.setErrore(new commentIdException());
		return a;
		
	}

	
	public Vector<CommentMethods> getAllComments () {
		this.listaCommenti.clear();
		String id;
		JSONObject prova=this.downloadApi("https://graph.facebook.com/101440919065369/posts?access_token=EAAcBZAami7SkBALEEiq8kksXCZCOaDnDRg15d75XAmo2yKHfMgBojWDhaVatR6zAndCgveSvIAHZA6YTAO87vZCGOKTh2N8tWqc6oZBaT5r1Oes15P6I1UuAoCWSqDI5hi4RTKCoG3zzAIUIrlLdPIAjIbo4rsSHXJZBGhiQmYUBHoExMEgjdxYsepxWDDPMsZD");
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




