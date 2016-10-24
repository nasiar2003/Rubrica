package it.polito.tdp.rubrica.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un insieme degli elementi {@link Voce} per poter gestire la rubrica
 * 
 * @author spydaman
 *
 */

public class Model {
	private List<Voce>voci;
	
	
	
	
	public Model(){
		this.voci= new ArrayList<>();
	}
	
	/**
	 * Aggiunge una nuova voce dentro la lista delle voce, prima controlla se è presente 
	 * dentro la lista ritorna {@code false} .
	 * @param voce  da aggiungere dentro la lista
	 * @return  ritorna {@code true} se la voce è stata aggiunta correttamente
	 */
	public boolean addVoce(Voce voce){
		if(voci.contains(voce)){
			return false;
		}
		
		voci.add(voce);
		
		
		return true;
		
	}
	/**
	 * cerca il nome dentro la lista se non trova ritorna {@code null} se non è presente
	 * 
	 * @param nome la stringa nome da cercare
	 * @return ritorna la {@code Voce}
	 * 
	 * 
	 * 
	 */
	public Voce findVoceByNome(String nome){
		
		Voce v= this.binarySearch(nome, voci.size());
		
		
		return v;
		
		
	}

	/**
	 * Cancella un elemento esistente controlla prima se non c'è ritorna {@code false} 
	 * 
	 * @param nome il parametro tipo {@code String} da cancellare
	 * @return {@code true} se cancella {@link Voce } 
	 */
	public boolean cancellaVoce(String nome){
		Voce v= this.binarySearch(nome, voci.size());
		
		if(v==null){
			return false;
			
		}
		else
			this.voci.remove(v);
			return true;
		
		
	}

	
	
	private Voce binarySearch (String nome, int size){
		int inizio =0;
		int fine = voci.size();
		
		while(inizio!=fine){
			int medio = inizio+(fine-inizio)/2;
			
			if(nome.compareToIgnoreCase(voci.get(medio).getNome())==0){
				return voci.get(medio);
				
			}
			else if(nome.compareToIgnoreCase(voci.get(medio).getNome())>0){
				
				inizio=medio+1;
			}
			else{
				
				inizio=medio;
			}
			
			
		}
		
		return null;
		
	}
	
	
	
}
