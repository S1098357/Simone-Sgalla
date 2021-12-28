package ProgettoPO.ProgettoProgrammazione.StatsFilters;
import java.util.List;
import java.util.Vector;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.exceptions.InvalidDate;
import ProgettoPO.ProgettoProgrammazione.exceptions.InvalidHour;
import ProgettoPO.ProgettoProgrammazione.exceptions.InvalidName;

/**
 * Classe in cui sono esplicitati i metodi relativi ai filtri per data, ora e utente
 */

public class CommentFilters {
	
	/**
	 * Metodo che, a seconda della data inserita dall'utente, restituisce tutti i commenti fatti in quella data
	 * @see CommentMethods
	 * @param listaCommenti Lista popolata da tutti i commenti della pagina mediante la funzione gettAllComments
	 * @param giornoScelto Giorno inserito dall'utente (data) di cui si vogliono sapere i commenti 
	 * @return una lista contenente i commenti filtrati per quella data nel caso in cui vi siano commenti in quella data 
	 * @throws InvalidDate se la data inserita dall'utente non è valida o non esistono commenti nella data inserita
	 */
	
	public Vector<Comment> filtroGiorni(List<Comment> listaCommenti, int giornoScelto) throws InvalidDate {
		int giorno;
		String appoggio;
		Vector<Comment> nuovaLista=new Vector<Comment>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			appoggio=listaCommenti.get(i).getCreatedTime();
			appoggio = appoggio.substring(8, 10);
			giorno=Integer.parseInt(appoggio);
			if(giorno==giornoScelto)nuovaLista.add(listaCommenti.get(i));
		}
		if (nuovaLista.size()==0) throw new InvalidDate();
		return nuovaLista;
	}
	
	/**
	 * Metodo che, a seconda dell'ora scelta, restituisce tutti i commenti fatti in quell' orario
	 * @param listaCommenti Lista popolata da tutti i commenti della pagina mediante la funzione gettAllComments
	 * @param oraScelta Orario inserito dall'utente di cui si vogliono sapere i commenti 
	 * @return una lista contenente i commenti filtrati per quell' ora nel caso in cui vi siano commenti in quell'ora 
	 * @throws InvalidHour se l'ora inserita dall'utente non è valida o non esistono commenti nell'ora inserita
	 */
	
	public Vector<Comment> filtroOre(List<Comment> listaCommenti, int oraScelta) throws InvalidHour {
		int ora;
		String appoggio;
		Vector<Comment> nuovaLista=new Vector<Comment>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			appoggio=listaCommenti.get(i).getCreatedTime();
			appoggio = appoggio.substring(11, 13);
			ora=Integer.parseInt(appoggio);
			if(ora==oraScelta)nuovaLista.add(listaCommenti.get(i));
		}
		if (nuovaLista.size()==0) throw new InvalidHour();
		return nuovaLista;
	}
	
	/**
	 * Metodo che, a seconda dell'utente scelto, restituisce tutti i commenti fatti da quell'utente
	 * @param listaCommenti Lista popolata da tutti i commenti della pagina mediante la funzione gettAllComments
	 * @param utenteScelto  Nome dell'utente inserito dall'utente di cui si vogliono sapere i commenti 
	 * @return una lista contenente i commenti fatti da un utente nel caso in cui vi siano commenti per quell'utente
	 * @throws InvalidName se il nome inserito dall'utente non è valido o non esistono commenti di quell'utente
	 */
	
	public Vector<Comment> filtroUtenti (List<Comment> listaCommenti, String utenteScelto) throws InvalidName {
		String utente;
		Vector<Comment> nuovaLista = new Vector<Comment>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			utente=listaCommenti.get(i).getFrom();
			if(utente.equals(utenteScelto))nuovaLista.add(listaCommenti.get(i));
		}
		if (nuovaLista.size()==0) throw new InvalidName();
		return nuovaLista;
	}
	 
}
