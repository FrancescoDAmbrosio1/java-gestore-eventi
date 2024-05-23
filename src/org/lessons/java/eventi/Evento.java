package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.ZoneId;


public class Evento {
	
	private String titolo;
	private String data;
	private int postiTotali;
	private static int postiPrenotati;

	//costruttore
	public Evento(String titolo, String data, int postiTotali, int postiPrenotati) {
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

	LocalDate dataLocale = LocalDate.now(ZoneId.of("Europe/Rome"));
	LocalDate dataEvento = inserisciData();
	
	public LocalDate inserisciData() {
		int anno = 0;
		int mese = 0;
		int giorno = 0;
		LocalDate dataEvento = LocalDate.of(anno, mese, giorno);
		return dataEvento;
	}
	
	// metodo che aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha 
	// posti disponibili deve restituire un messaggio di avviso.
	
	public int prenota() {
		int postoInPrenotazione;
		if(dataEvento.isAfter(dataLocale)) {
			postoInPrenotazione = postiPrenotati + 1;
			System.out.println("Estato prenotato un posto per l'avento selezionato.");
		} else {
			postoInPrenotazione = postiPrenotati;
			System.out.println("ATTENZIONE --- L'evento è già passato...non è stato prenotato alcun posto!!!!");
		}
		return postoInPrenotazione;
	}
	
	// metodo che riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono  
	// prenotazioni restituisce un messaggio di avviso.

	public void disdici() {
		
	}
	
	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data + "]";
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

}
