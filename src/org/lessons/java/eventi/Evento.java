package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Evento {
	
	public String titolo;
	public LocalDate data;
	protected int postiTotali;
	private int postiPrenotati;
	public boolean result;
	public int postiDisponibili;
	

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
	
	public int prenota(int input, int disponibili) {
		if(data.isBefore(dataLocale) || (disponibili - input) < 0) {
			result = true;
		} else {
			postiPrenotati += 1;
		}
		return postiPrenotati;
	}
	
	public int calcoloPostiDisponibili() {
		postiDisponibili = postiTotali - postiPrenotati;
		return postiDisponibili;
	}
	
	public void outputPrenotazione(String titoloEvento, int postiDaPrenotare) {
		if(result == true) {
			System.out.println("\nATTENZIONE --> L'evento è già passato e non è stato prenotato "
					+ "alcun posto oppure i posti richiesti sono superiori a quelli disponibili.\n");			
			result = false;
		} else {
			System.out.println("\nPer l'evento " + titoloEvento.toString() + " sono stati prenotati n° "
					+ " " + postiDaPrenotare + " posti.");
		}
		resocontoPostiEvento();
	}
	
	// metodo che riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono  
	// prenotazioni restituisce un messaggio di avviso.

	public int disdici() {		
		if(data.isBefore(dataLocale)) {
			System.out.println("\nATTENZIONE --- L'evento è già passato...non è stato disdetto alcun posto!!!!\n");
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

	public boolean verificaData(CharSequence input, LocalDate dataLocale) {
		boolean result = false;
		data = LocalDate.parse(input);
		if(data.isBefore(dataLocale)) {
			System.out.println("Data inserita non valida....Inserire una data successiva a quella odierna");
			result = true;
		}
		return result;
	}
	
	public void setData(LocalDate input) {
		this.data = input;
	}

	public int getPostiTotali() {
		return postiTotali;
	}


	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	
	public void resocontoPostiEvento() {
		System.out.println("\nResoconto posti evento --> \n"
				+ "  	- Posti totali evento : " + getPostiTotali() +
				"\n  	- Posti ancora disponibili : " + (getPostiTotali() - getPostiPrenotati()));
	}

	public static void stampaMenu() {
		System.out.println("\nDigitare il numero dell'attività da eseguire: \n"
				+ "[1] - Inserisci un nuovo evento generico\n"
				+ "[2] - Inserisci un nuovo evento di tipo Concerto\n"
				+ "[3] - Prenota posti\n"
				+ "[4] - Disdici posti\n"
				+ "[5] - Visualizza lista eventi in programmazione\n"
				+ "[6] - Cancella intera programmazione eventi\n"
				+ "[7] - Ricerca evento per data\n"
				+ "[8] - Esci dal programma\n");
	}
	
	public static void header() {
		System.out.println("--------------------------------------------------------");
		System.out.println("------------------- GESTORE EVENTI ---------------------");
		System.out.println("--------------------------------------------------------\n");
	}
	
	public static void footer() {
		System.out.println("--------------------------------------------------------");
		System.out.println("------------------ USCITA DAL PROGRAMMA ---------------");
		System.out.println("--------------------***** BYE BYE *****-----------------");
		System.out.println("--------------------------------------------------------");		
	}
	
	
}
