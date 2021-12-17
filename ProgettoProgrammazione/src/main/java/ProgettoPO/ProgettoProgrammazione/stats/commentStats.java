package ProgettoPO.ProgettoProgrammazione.stats;

import ProgettoPO.ProgettoProgrammazione.entities.*;

import java.util.List;
import java.util.Vector;

public class commentStats {
	//static int contatore = 0;
	
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
	
	public String orarioMax (Vector <Comment> commenti) {
		int[] ore = new int[commenti.size()];
		int[] minuti = new int[commenti.size()];
		int oraMax=0, minutiMax=0;
		String[] orari = new String [commenti.size()];
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
	
	public String orarioMin (Vector <Comment> commenti) {
		int[] ore = new int[commenti.size()];
		int[] minuti = new int[commenti.size()];
		int oraMin=23, minutiMin=59;
		String[] orari = new String [commenti.size()];
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
	
	
	public String mediaLike(List<Comment> listaCommenti)
	{
		int media=0;
		String Media;
		String resto;
		for(int i=0; i<listaCommenti.size();i++)
			media+=listaCommenti.get(i).getLikeCount();
		Media=Integer.toString(media/listaCommenti.size());
		resto=Integer.toString(media%listaCommenti.size());
		return Media+"."+resto;
	}

	public String mediaRisposte(List<Comment> listaCommenti)
	{
		int media=0;
		String resto,Media;
		for(int i=0; i<listaCommenti.size();i++)
			media+=listaCommenti.get(i).getCommentCount();
		Media=Integer.toString(media/listaCommenti.size());
		resto=Integer.toString(media%listaCommenti.size());
		return Media+"."+resto;
	}
	
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
	
	
	public Vector<Comment> filtroGiorni(List<Comment> listaCommenti, int giornoScelto)
	{
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
		return nuovaLista;
	}
	
	
	public Vector<Comment> filtroOre(List<Comment> listaCommenti, int oraScelta)
	{
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
		return nuovaLista;
	}
	
	public Vector<Comment> filtroUtenti(List<Comment> listaCommenti, String utenteScelto)
	{
		String utente;
		Vector<Comment> nuovaLista=new Vector<Comment>();
		for(int i=0; i<listaCommenti.size();i++)
		{
			utente=listaCommenti.get(i).getFrom();
			if(utente.equals(utenteScelto))nuovaLista.add(listaCommenti.get(i));
		}
		return nuovaLista;
	}
		
		public String numCommentiUtente(List<Comment> listaCommenti, String utenteScelto) {
			String utente;
			int contatore=0;
			for(int i=0; i<listaCommenti.size();i++)
			{
				utente=listaCommenti.get(i).getFrom();
				if(utente.equals(utenteScelto))contatore++;
			}
			utente = Integer.toString(contatore);
			return utente;
}
		
		public Vector<String> frequenzaUtente(List<Comment> listaCommenti, String utenteScelto)
		{
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
			return nuovaLista;
		}
			
}

