package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Evento {
	
	public String titolo;
	public static LocalDate data;
	protected int postiTotali;
	private int postiPrenotati;
	

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
	}
	return postiPrenotati;
		
	}
	
	@Override
	public String toString() {
		String dataFormattata = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return "\ndata: " + dataFormattata + " - " + " titolo: " + getTitolo();
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

	public static boolean setData(CharSequence input, LocalDate dataLocale) {
		boolean result = false;
		data = LocalDate.parse(input);
		if(data.isBefore(dataLocale)) {
			System.out.println("Data inserita non valida....Inserire una data successiva a quella odierna");
			result = true;
		}
		return result;
	}

	public int getPostiTotali() {
		if(postiTotali < 0) {
			System.out.println("Il numero di posti totali disponibili non è valido.");
		}
		return postiTotali;
	}
	
//	public int setPostiTotali(int input) {
//		if(input < 0) {
//			System.out.println("Il numero di posti totali disponibili non è valido.");
//		} else {
//			postiTotali = input;
//		}
//		return postiTotali;
//	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
//	public int setPostiPrenotati() {
//		return postiPrenotati;
//	}
	
	public void resocontoPostiEvento() {
		System.out.println("Resoconto posti evento --> \n"
				+ "  - Posti totali evento : " + getPostiTotali() +
				"\n  - Posti ancora disponibili : " + (getPostiTotali() - getPostiPrenotati()));
	}

	public static void stampaMenu() {
		System.out.println("\nDigitare il numero dell'attività da eseguire: \n"
				+ "[1] - Inserisci un nuovo evento generico\n"
				+ "[2] - Inserisci un nuovo evento di tipo Concerto\n"
				+ "[3] - Prenota posti\n"
				+ "[4] - Disdici posti\n"
				+ "[5] - Visualizza lista eventi in programmazione\n"
				+ "[6] - Cancella intera programmazione eventi\n"
				+ "[7] - Esci dal programma\n");
	}
	
	
}
