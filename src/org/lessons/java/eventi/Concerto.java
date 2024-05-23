package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

	//attributi proprio della classe Concerto
	private LocalTime oraLocale;
	private double prezzo;
	
	public Concerto(String titolo, LocalDate data2, int postiTotali, int postiPrenotati) {
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

}
