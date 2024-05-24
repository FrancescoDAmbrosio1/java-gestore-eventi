package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Evento {
	
	public String titolo;
	public LocalDate data;
	protected int postiTotali;
	private static int postiPrenotati;

	//costruttore
	public Evento(String titolo, LocalDate data, int postiTotali, int postiPrenotati) {
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

	LocalDate dataLocale = LocalDate.now(ZoneId.of("Europe/Rome"));
	
	
	// metodo che aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha 
	// posti disponibili deve restituire un messaggio di avviso.
	
	public int prenota() {
		if(data.isBefore(dataLocale) || postiPrenotati == postiTotali) {
			System.out.println("-------------------  ATTENZIONE ---------------- \n"
					+ "L'evento è già passato e non è stato prenotato alcun posto oppure non ci sono più"
					+ "posti disponibili!!!!");
		} else {
			postiPrenotati += 1;
			System.out.println("E' stato prenotato un posto per l'avento selezionato.");
		}
		return postiPrenotati;
	}
	
	// metodo che riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono  
	// prenotazioni restituisce un messaggio di avviso.

	public int disdici() {		
		if(data.isBefore(dataLocale)) {
			System.out.println("ATTENZIONE --- L'evento è già passato...non è stato disdetto alcun posto!!!!");
		} else {
			postiPrenotati -= 1;
			System.out.println("E' stato disdetto un posto per l'avento selezionato.");
	}
	return postiPrenotati;
		
	}
	
	@Override
	public String toString() {
		String dataFormattata = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return dataFormattata + " - " + " titolo: " + getTitolo() + "\n";
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public boolean setData(CharSequence input) {
		boolean result = false;
		data = LocalDate.parse(input);
		if(data.isBefore(dataLocale)) {
			System.out.println("Data inserita non valida....Inserire una data successiva a quella odierna");
			result = true;
		} else {
			System.out.println("La data inserita è corretta");
		}
		return result;
	}

	public int getPostiTotali() {
		return postiTotali;
	}
	
	public int setPostiTotali(int input) {
		if(input < 0) {
			System.out.println("Il numero di posti totali disponibili non è valido.");
		} else {
			postiTotali = input;
		}
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public int setPostiPrenotati() {
		return postiPrenotati;
	}

}
