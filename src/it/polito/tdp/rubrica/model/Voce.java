package it.polito.tdp.rubrica.model;
/**
 * rapresenta un singolo elemento della rubrica
 * 
 * @author spydaman
 *
 */

public class Voce implements Comparable<Voce> {
	
	
	private String nome;
	private String email;
	private String telefono;
	
	
	
	public Voce(String nome, String email, String telefono) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefono = telefono;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voce other = (Voce) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}



	@Override
	public int compareTo(Voce a) {
		if(this.nome.compareToIgnoreCase(a.getNome())!=0){
			return this.nome.compareToIgnoreCase(a.getNome());
		}
		else if(this.email.compareTo(a.email)!=0){
			return this.email.compareTo(a.email);
		}
			else if(this.telefono.compareTo(a.telefono)!=0){
				return this.telefono.compareTo(a.telefono);
			}
		
		return 0;
	}



	@Override
	public String toString() {
		return  nome ;
	}
	
	
	

}
