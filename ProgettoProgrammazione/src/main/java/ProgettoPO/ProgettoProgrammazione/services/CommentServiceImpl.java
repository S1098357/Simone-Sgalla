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
import ProgettoPO.ProgettoProgrammazione.exceptions.*;

/**
 * Classe di gestione dei servizi. In questa sono esplicitati tutti i metodi elencati nell'interfaccia madre.
 */

@Service
public class CommentServiceImpl implements CommentService {
	public Vector <Comment> listaCommenti = new Vector<Comment>();
	
	
	/**
	 * Metodo che permette di scaricare tutti i dati dell'Api sotto forma di JSONObject. Accetta come argomento un url di 
	 * riferimento, dove sono contenute le informazioni.
	 * @param url Url di riferimento, dove sono contenute le informazioni
	 * @return Restituisce un oggetto (JSONObject) contenente tutti i dati dell'Api
	 */
	
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
			 } 
			finally {
			   in.close();
			 }
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data);	
			return obj;
		} catch (IOException | ParseException e) {}
		catch (Exception e) {}
		return null;
	}
	
	
	/**
	 * Metodo che restituisce sotto forma di JSONObject tutti i post di una pagina Facebook
	 * @return Restituisce un oggetto (JSONObject) contenente tutti i post della pagina di cui si inserisce l'AccessToken
	 */
	
	@Override
	public JSONObject getPosts() {
		return this.downloadApi("https://graph.facebook.com/me?fields=posts&access_token=");
		}

	/**
	 * Metodo che restituisce tutti i commenti, e le relative informazioni, sotto ad un determinato post
	 * @see Comment
	 * @param postId Id del post di cui si vuole avere i commenti
	 * @return Una lista di Comment sotto ad un determinato post nel caso in cui l'id inserito sia valido
	 * @throws PostIdException 
	 */
	
	@Override
	public Vector<Comment> getComments(String postId) throws PostIdException {
		JSONObject prova=null;
		String preUrl="https://graph.facebook.com/";
		String id;
		String postUrl="?fields=parent,id,message,from,created_time,permalink_url,can_comment,can_like,user_likes,comment_count,like_count&access_token=";
		String postPostUrl="/comments?access_token=";
		prova=this.downloadApi(preUrl+postId+postPostUrl);
		JSONObject commento;
		JSONArray risposte;
		if (prova==null) throw new PostIdException();
		JSONArray obj=(JSONArray)prova.get("data");
		for(int i=0;i<obj.size();i++) {
			prova=(JSONObject) obj.get(i);
			id=(String)prova.get("id");
			commento=this.downloadApi(preUrl+id+postUrl);
			this.listaCommenti.add(new Comment(commento));
			id=(String)commento.get("id");
			commento=this.downloadApi(preUrl+id+postPostUrl);
			if(commento.get("data")!=null) {
				risposte= (JSONArray) commento.get("data");
				for(int j=0;j<risposte.size();j++) {
					commento=(JSONObject)risposte.get(j);
					id=(String) commento.get("id");
					this.listaCommenti.add(new Comment(this.downloadApi(preUrl+id+postUrl)));
				}
			}
		
		}
		return listaCommenti;
	}
	
	/**
	 * Metodo che restituisce un singolo commento, ricercato tramite id, e tutte le sue informazioni
	 * @see Comment
	 * @param id Id del commento di cui si vogliono le informazioni
	 * @return il commento (Comment) singolo con quel determinato id, e le relative informazioni, 
	 * preso dalla lista di commenti, nel caso in cui l'id sia valido
	 * @throws CommentIdException 
	 */
	
	@Override
	public Comment getComment(String id) throws CommentIdException  {
		for (int i=0;i<listaCommenti.size();i++)
		{
			if(id.equals(listaCommenti.get(i).getId()))
			{
				return listaCommenti.get(i);
			}
		}
		throw new CommentIdException();
		}

	/**
	 * Metodo che restituisce tutti i commenti della pagina
	 * @see Comment
	 * @return una lista di tutti i commenti (Comment) della pagina e le relative informazioni
	 * @throws PostIdException 
	 */
	
	public Vector <Comment> getAllComments () throws PostIdException {
		this.listaCommenti.clear();
		String id;
		JSONObject prova=this.downloadApi("https://graph.facebook.com/101440919065369/posts?access_token=");
		JSONArray obj=(JSONArray)prova.get("data");
		for(int i=0;i<obj.size();i++) {
			prova=(JSONObject) obj.get(i);
			id=(String)prova.get("id");
			this.getComments(id);
		}
	return listaCommenti;
	}
		
		
	}




