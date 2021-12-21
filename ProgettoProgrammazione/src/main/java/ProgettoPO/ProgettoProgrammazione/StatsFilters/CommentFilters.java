package ProgettoPO.ProgettoProgrammazione.StatsFilters;

import java.util.List;
import java.util.Vector;

import ProgettoPO.ProgettoProgrammazione.entities.CommentError;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.exceptions.InvalidDate;
import ProgettoPO.ProgettoProgrammazione.exceptions.InvalidHour;
import ProgettoPO.ProgettoProgrammazione.exceptions.InvalidName;

public class CommentFilters {
	
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
