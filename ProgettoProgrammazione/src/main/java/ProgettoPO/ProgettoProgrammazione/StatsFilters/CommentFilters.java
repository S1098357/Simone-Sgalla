package ProgettoPO.ProgettoProgrammazione.StatsFilters;
import java.util.List;
import java.util.Vector;

import ProgettoPO.ProgettoProgrammazione.entities.CommentError;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
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
	 * @return una lista contenente un singolo messaggio (commento) di errore nel caso in cui non sono presenti 
	 * commenti per quella data
	 */
	
	public Vector<CommentMethods> filtroGiorni(List<CommentMethods> listaCommenti, int giornoScelto) 
	{
		int giorno;
		String appoggio;
		Vector<CommentMethods> nuovaLista=new Vector<CommentMethods>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			appoggio=listaCommenti.get(i).retCreatedTime();
			appoggio = appoggio.substring(8, 10);
			giorno=Integer.parseInt(appoggio);
			if(giorno==giornoScelto)nuovaLista.add(listaCommenti.get(i));
		}
		if (nuovaLista.size()==0) {
			CommentError a = new CommentError();
			a.setErrore(new InvalidDate());
			nuovaLista.add(a);
			return nuovaLista;
		}
		return nuovaLista;
	}
	
	/**
	 * Metodo che, a seconda dell'ora scelta, restituisce tutti i commenti fatti in quell' orario
	 * @param listaCommenti Lista popolata da tutti i commenti della pagina mediante la funzione gettAllComments
	 * @param oraScelta Orario inserito dall'utente di cui si vogliono sapere i commenti 
	 * @return una lista contenente i commenti filtrati per quell' ora nel caso in cui vi siano commenti in quell'ora
	 * @return una lista contenente un singolo messaggio (commento) di errore nel caso in cui non sono presenti 
	 * commenti per quell'ora
	 */
	
	public Vector<CommentMethods> filtroOre(List<CommentMethods> listaCommenti, int oraScelta)
	{
		int ora;
		String appoggio;
		Vector<CommentMethods> nuovaLista=new Vector<CommentMethods>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			appoggio=listaCommenti.get(i).retCreatedTime();
			appoggio = appoggio.substring(11, 13);
			ora=Integer.parseInt(appoggio);
			if(ora==oraScelta)nuovaLista.add(listaCommenti.get(i));
		}
		if (nuovaLista.size()==0) {
			CommentError a = new CommentError();
			a.setErrore(new InvalidHour());
			nuovaLista.add(a);
			return nuovaLista;
		}
		return nuovaLista;
	}
	
	/**
	 * Metodo che, a seconda dell'utente scelto, restituisce tutti i commenti fatti da quell'utente
	 * @param listaCommenti Lista popolata da tutti i commenti della pagina mediante la funzione gettAllComments
	 * @param utenteScelto  Nome dell'utente inserito dall'utente di cui si vogliono sapere i commenti 
	 * @return una lista contenente i commenti fatti da un utente nel caso in cui vi siano commenti per quell'utente
	 * @return una lista contenente un singolo messaggio (commento) di errore nel caso in cui non sono presenti 
	 * commenti fatti da quell'utente
	 */
	
	public Vector<CommentMethods> filtroUtenti (List<CommentMethods> listaCommenti, String utenteScelto) 
	{
		String utente;
		Vector<CommentMethods> nuovaLista=new Vector<CommentMethods>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			utente=listaCommenti.get(i).retFrom();
			if(utente.equals(utenteScelto))nuovaLista.add(listaCommenti.get(i));
		}
		if (nuovaLista.size()==0) {
			CommentError a = new CommentError();
			a.setErrore(new InvalidName());
			nuovaLista.add(a);
			return nuovaLista;
		}
		return nuovaLista;
	}
	 
}
