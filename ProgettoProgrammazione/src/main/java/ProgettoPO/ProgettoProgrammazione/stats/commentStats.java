package ProgettoPO.ProgettoProgrammazione.stats;

import ProgettoPO.ProgettoProgrammazione.entities.*;
import ProgettoPO.ProgettoProgrammazione.exceptions.*;
import java.util.List;
import java.util.Vector;

public class commentStats {
	static int contatore = 0;
	
	public String mediaOrario (Vector <CommentMethods> commenti) {
		int sommaOre=0, sommaMinuti = 0;
		String ore, minuti;
		for (int i = 0; i<commenti.size();i++) {
			String orario = commenti.get(i).retCreatedTime();
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
	
	public String orarioMax (Vector <CommentMethods> commenti) {
		int[] ore = new int[commenti.size()];
		int[] minuti = new int[commenti.size()];
		int oraMax=0, minutiMax=0;
		for (int i = 0; i<commenti.size();i++) {
			String orario = commenti.get(i).retCreatedTime();
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
	
	public String orarioMin (Vector <CommentMethods> commenti) {
		int[] ore = new int[commenti.size()];
		int[] minuti = new int[commenti.size()];
		int oraMin=23, minutiMin=59;
		for (int i = 0; i<commenti.size();i++) {
			String orario = commenti.get(i).retCreatedTime();
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
	
	
	public String mediaLike(List<CommentMethods> listaCommenti)
	{
		int media=0;
		String Media;
		String resto;
		for(int i=0; i<listaCommenti.size();i++)
			media+=listaCommenti.get(i).retLikeCount();
		Media=Integer.toString(media/listaCommenti.size());
		resto=Integer.toString(media%listaCommenti.size());
		return Media+"."+resto;
	}

	public String mediaRisposte(List<CommentMethods> listaCommenti)
	{
		int media=0;
		String resto,Media;
		for(int i=0; i<listaCommenti.size();i++)
			media+=listaCommenti.get(i).retCommentCount();
		Media=Integer.toString(media/listaCommenti.size());
		resto=Integer.toString(media%listaCommenti.size());
		return Media+"."+resto;
	}
	
	public String mediaCommentiAlGiorno(List<CommentMethods> listaCommenti)
	{
		String media;
		String resto;
		int giorno;
		int giornoMin=32;
		int giornoMax=0;
		String appoggio;
		for(int i=0; i<listaCommenti.size();i++)
		{
			appoggio=listaCommenti.get(i).retCreatedTime();
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
			a.setErrore(new invalidDate());
			nuovaLista.add(a);
			return nuovaLista;
		}
		return nuovaLista;
	}
	
	
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
			a.setErrore(new invalidHour());
			nuovaLista.add(a);
			return nuovaLista;
		}
		return nuovaLista;
	}
	
	
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
			a.setErrore(new invalidName());
			nuovaLista.add(a);
			return nuovaLista;
		}
		return nuovaLista;
	}
	 
	
	
	
	
		public String numCommentiUtente(List<CommentMethods> listaCommenti, String utenteScelto) {
			String utente;
			contatore=0;
			for(int i=0; i<listaCommenti.size();i++)
			{
				utente=listaCommenti.get(i).retFrom();
				if(utente.equals(utenteScelto))contatore++;
			}
			utente = Integer.toString(contatore);
			if (contatore==0) {
				CommentError a = new CommentError();
				a.setErrore(new invalidName());
				return a.getErrore();
			}
			return utente;
}
		
		public Vector<String> frequenzaUtente (List<CommentMethods> listaCommenti, String utenteScelto) 
		{
			int contatore=0;
			String utente;
			Vector<String> nuovaLista=new Vector<String>();
			for(int i=0; i<listaCommenti.size();i++)
			{
				utente=listaCommenti.get(i).retFrom();
				if(utente.equals(utenteScelto)) {
					contatore++;
					nuovaLista.add(contatore+"°"+ " Commento alle ore: " + listaCommenti.get(i).retCreatedTime());
				}
			}
			if (contatore==0) {
				CommentError a = new CommentError();
				a.setErrore(new invalidName());
				nuovaLista.add(a.getErrore());
				return nuovaLista;
			}
			return nuovaLista;
		}
			
}

