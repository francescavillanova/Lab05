package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private AnagrammaDAO anagrammaDao;
	public List<String> anagrammi;

	public Model() {
		this.anagrammaDao = new AnagrammaDAO();
		this.anagrammi=new LinkedList<String>();
	}
	
	public boolean isCorrect(String anagramma) {
		return this.anagrammaDao.isCorrect(anagramma);
	}
	
	public void anagramma(String s) {
		
		anagrammi.clear(); //pulisco la lista ogni volta che viene inserita una nuova parola 
		anagramma_ricorsiva("", 0, s);
	}

	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length()==0) { 
		   anagrammi.add(parziale); 
		}else {
			for(int pos=0; pos<rimanenti.length(); pos++) {
				String nuova_parziale=parziale+rimanenti.charAt(pos);   
				String nuova_rimanenti=rimanenti.substring(0, pos)+rimanenti.substring(pos+1); 
				anagramma_ricorsiva(nuova_parziale, livello+1, nuova_rimanenti);
								
			}
		}
	}
	
	public List<String> corretti(List<String> anagrammi){
		List<String> listaCorretti=new LinkedList<String>();
		for(String s: anagrammi) {
			if(isCorrect(s)) 
				listaCorretti.add(s);
						
		}
		
		return listaCorretti;
	}
	
	public List<String> errati(List<String> anagrammi){
		List<String> listaErrati=new LinkedList<String>();
		for(String s: anagrammi) {
			if(!isCorrect(s)) 
				listaErrati.add(s);
				
		}
		
		return listaErrati;
	}
	
}
