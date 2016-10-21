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
		for(int i=0; i<voci.size();++i){
			if(voci.get(i).getNome().equals(nome)){
				  
				return voci.get(i);
			}
		}
		
		return null;
		
		
	}

	
	

	
	
	
}
