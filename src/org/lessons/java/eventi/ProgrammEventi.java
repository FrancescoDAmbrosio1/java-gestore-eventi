package org.lessons.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi; 
	
	public ProgrammEventi(String titolo){
		this.titolo = titolo;
		this.eventi = new ArrayList<Evento>();
	}
	
	@Override
	public String toString() {
		return "\n" + titolo + ", eventi: " + eventi;
	}

	//metodo che aggiunge alla lista un nuovo evento
	public void aggiungiEvento(Evento input){
		eventi.add(input);
	}
	
	//metodo che restituisce eventi per data
	public List<Evento> listaPerData(LocalDate input){
		List<Evento> eventiPerData = new ArrayList<Evento>();
			for(int i = 0; i < eventi.size(); i++) {
				if(input.equals(eventi.get(i).getData())) {
					eventiPerData.add(eventi.get(i));
				}
			}
		return eventiPerData;
	}
	
	//metodo che restituisce quanti eventi nel programma
	public int numeroEventiProgramma() {
		int numeroEventi = eventi.size();
		return numeroEventi;
	}
	
	//metodo per svuotare la lista di eventi
	public void svuotaElencoProgrammi(String input){
		String risposta = input.toLowerCase();
		if(risposta.equals("si")) {
			eventi.clear();
			System.out.println("La lista di eventi è stata cancellata.");			
		} else {
			System.out.println("L'operazione di cancellazione lista eventi è stata annullata.");
		}
	}
	
	//metodo che restituisce lista eventi ordinati per data
	public List<Evento> listaOrdinataPerData(){
//		List<Evento> eventiOrdinata = new ArrayList<Evento>();
		Collections.sort(eventi);
		return eventi;
	}


	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void get(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public Evento eventoPosti(String input) {
		Evento eventoSelezionato = null;
		for (int i = 0; i < eventi.size(); i++) {
			if (input.equals(eventi.get(i).titolo)) {
				eventoSelezionato = eventi.get(i);
			}
		}
		return eventoSelezionato;
	}
		

}
