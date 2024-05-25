package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Concerto extends Evento {

	//attributi proprio della classe Concerto
	private LocalTime oraLocale;
	private double prezzo;
	
	public Concerto(String titolo, LocalDate data2, int postiTotali, int postiPrenotati, 
			LocalTime oraLocale, double prezzo) {
		super(titolo, data2, postiTotali, postiPrenotati);
		this.oraLocale = oraLocale;
		this.prezzo = prezzo;
		
	}



	public LocalTime getOraLocale() {
		return oraLocale;
	}

	public void setOraLocale(LocalTime oraLocale) {
		this.oraLocale = oraLocale;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String formattaOra() {
		String oraFormattata =  oraLocale.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
		return oraFormattata;
	}
	
	public String formattaPrezzo() {
		String prezzoFormattato = String.format("%.02f", prezzo);
		return prezzoFormattato + "€.";
	}

	@Override
	public String toString() {
		return super.toString() + " - Orario inizio: " + formattaOra() + " - Costo biglietto: "
				+ formattaPrezzo();
	}
}
