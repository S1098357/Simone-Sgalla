package ProgettoPO.ProgettoProgrammazione.StatsFilters;
import ProgettoPO.ProgettoProgrammazione.entities.*;
import ProgettoPO.ProgettoProgrammazione.exceptions.*;
import java.util.List;
import java.util.Vector;

/**
 * Classe in cui sono esplicitati i metodi relativi alle  statistiche realizzate sui commenti
 */

public class CommentStats {
	
	/**
	 * Metodo che calcola la media dell'orario in cui vengono fatti i commenti
	 * @param commenti lista di commenti popolata mediante la funzione getAllComments
	 * @return una stringa in cui è indicato l'orario medio
	 */
	
	public String mediaOrario (Vector <Comment> commenti) {
		int sommaOre=0, sommaMinuti = 0;
		String ore, minuti;
		for (int i = 0; i<commenti.size();i++) {
			String orario = commenti.get(i).getCreatedTime();
			ore = orario.substring (11,13);
			minuti = orario.substring(14, 16);
			int ora = Integer.parseInt(ore);
			int minutaggio =  Integer.parseInt(minuti); 
			sommaOre += ora;
			sommaMinuti += minutaggio;
		}
		int mediaOre = sommaOre/(commenti.size());
		int mediaMinuti = sommaMinuti/(commenti.size());
		int scartoOre = sommaOre%commenti.size();
		float scarto = (scartoOre/commenti.size())*60;
		mediaMinuti+=scarto;
		ore = Integer.toString(mediaOre);
		minuti = Integer.toString(mediaMinuti);
		return ore+":"+minuti;
		}
	
	/**
	 * Metodo che restituisce l'orario più tardivo in cui è stato fatto un commento
	 * @param commenti lista di commenti popolata mediante la funzione getAllComments
	 * @return una stringa in cui è indicato l'orario più tardivo
	 */
	
	public String orarioMax (Vector <Comment> commenti) {
		int[] ore = new int[commenti.size()];
		int[] minuti = new int[commenti.size()];
		int oraMax=0, minutiMax=0;
		for (int i = 0; i<commenti.size();i++) {
			String orario = commenti.get(i).getCreatedTime();
			ore[i] = Integer.parseInt(orario.substring (11,13));
			minuti[i] = Integer.parseInt(orario.substring(14, 16));
			if (ore[i]>oraMax) oraMax=ore[i];
		}
		for (int i = 0; i<commenti.size();i++) {
			if (ore[i]==oraMax) {
				if (minutiMax<minuti[i]) minutiMax = minuti[i];
				}
			}
		String orario = Integer.toString(oraMax);
		String minutaggio = Integer.toString(minutiMax);
		return orario+":"+minutaggio;
		}
	
	/**
	 * Metodo che restituisce l'orario minore in cui è stato fatto un commento
	 * @param commenti lista di commenti popolata mediante la funzione getAllComments
	 * @return una stringa in cui è indicato l'orario minore
	 */
	
	public String orarioMin (Vector <Comment> commenti) {
		int[] ore = new int[commenti.size()];
		int[] minuti = new int[commenti.size()];
		int oraMin=23, minutiMin=59;
		for (int i = 0; i<commenti.size();i++) {
			String orario = commenti.get(i).getCreatedTime();
			ore[i] = Integer.parseInt(orario.substring (11,13));
			minuti[i] = Integer.parseInt(orario.substring(14, 16));
			if (ore[i]<oraMin) oraMin=ore[i];
		}
		for (int i = 0; i<commenti.size();i++) {
			if (ore[i]==oraMin) {
				if (minutiMin>minuti[i]) minutiMin = minuti[i];
				}
			}
		String orario = Integer.toString(oraMin);
		String minutaggio = Integer.toString(minutiMin);
		return orario+":"+minutaggio;
		}
	
	/**
	 * Metodo che restituisce la media di like per commento
	 * @param listaCommenti lista di commenti popolata mediante la funzione getAllComments
	 * @return una stringa in cui è indicata la media di like
	 */
	
	public String mediaLike(List<Comment> listaCommenti)
	{
		int media=0;
		String Media;
		String resto;
		for(int i=0; i<listaCommenti.size();i++) media+=listaCommenti.get(i).getLikeCount();
		Media=Integer.toString(media/listaCommenti.size());
		resto=Integer.toString(media%listaCommenti.size());
		return Media+"."+resto;
	}
	
	/**
	 * Metodo che restituisce la media di risposte per commento
	 * @param listaCommenti lista di commenti popolata mediante la funzione getAllComments
	 * @return una stringa in cui è indicata la media di risposte
	 */
	
	public String mediaRisposte(List<Comment> listaCommenti)
	{
		int media=0;
		String resto,Media;
		for(int i=0; i<listaCommenti.size();i++) media+=listaCommenti.get(i).getCommentCount();
		Media=Integer.toString(media/listaCommenti.size());
		resto=Integer.toString(media%listaCommenti.size());
		return Media+"."+resto;
	}
	
	/**
	 * Metodo che restituisce la media di commenti al giorno
	 * @param listaCommenti lista di commenti popolata mediante la funzione getAllComments
	 * @return una stringa in cui è indicata la media di commenti al giorno
	 */
	
	public String mediaCommentiAlGiorno(List<Comment> listaCommenti)
	{
		String media;
		String resto;
		int giorno;
		int giornoMin=32;
		int giornoMax=0;
		String appoggio;
		for(int i=0; i<listaCommenti.size();i++)
		{
			appoggio=listaCommenti.get(i).getCreatedTime();
			appoggio = appoggio.substring(8, 10);
			giorno=Integer.parseInt(appoggio);
			if(giorno<giornoMin) giornoMin=giorno;
			if(giorno>giornoMax) giornoMax=giorno;
		}
		media=Integer.toString(listaCommenti.size()/(giornoMax-giornoMin));
		resto=Integer.toString(listaCommenti.size()/(giornoMax-giornoMin));
		appoggio=(String)media;
		return media+"."+resto;
	}
	
	 /**
	  * Metodo che calcola il numero di commenti per Utente
	  * @param listaCommenti lista di commenti popolata mediante la funzione getAllComments
	  * @param utenteScelto Nome dell'utente, inserito dall'utente, di cui si uole sapere il numero totale di commenti
	  * @return una stringa contentente il numero di commenti se l'utente inserito ha commentato
	  * @throws InvalidNameException 
	  */
	
	public String numCommentiUtente(List<Comment> listaCommenti, String utenteScelto) throws InvalidNameException {
		String utente;
		int contatore=0;
		for(int i=0; i<listaCommenti.size();i++)
		{
			utente=listaCommenti.get(i).getFrom();
			if(utente.equals(utenteScelto))contatore++;
		}
		utente = Integer.toString(contatore);
		if (contatore==0) throw new InvalidNameException();
		return utente;
		}
		
	/**
	 * Metodo che indica gli orario in cui sono stati fatti i commenti di un determinato utente
	 * @param listaCommenti lista di commenti popolata mediante la funzione getAllComments
	 * @param utenteScelto Nome dell'utente, inserito dall'utente, di cui si vogliono sapere gli orari dei commenti
	 * @return una lista di stringa in cui sono indicati gli orari dei commenti dell'utente inserito nel caso in cui l'utente 
	 * inserito abbia commentato
	 * @throws InvalidNameException 
	 */
	
	public Vector<String> frequenzaUtente (Vector<Comment> listaCommenti, String utenteScelto) throws InvalidNameException {
		int contatore=0;
		String utente;
		Vector<String> nuovaLista=new Vector<String>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			utente=listaCommenti.get(i).getFrom();
			if(utente.equals(utenteScelto)) {
				contatore++;
				nuovaLista.add(contatore+"°"+ " Commento alle ore: " + listaCommenti.get(i).getCreatedTime());
			}
		}
		if (contatore==0) throw new InvalidNameException();
		return nuovaLista;
	}
}

