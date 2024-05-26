package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	//attributi proprio della classe Concerto
	private LocalTime oraEvento;
	private double prezzo;
	
	public Concerto(String titolo, LocalDate data2, int postiTotali, int postiPrenotati, 
			LocalTime oraEvento, double prezzo) {
		super(titolo, data2, postiTotali, postiPrenotati);
		this.oraEvento = oraEvento;
		this.prezzo = prezzo;
		
	}



	public LocalTime getOraLocale() {
		return oraEvento;
	}

	public void setOraLocale(LocalTime oraEvento) {
		this.oraEvento = oraEvento;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String formattaOra() {
		String oraFormattata =  oraEvento.format(DateTimeFormatter.ofPattern("hh:mm"));
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
