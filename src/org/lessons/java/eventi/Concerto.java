package org.lessons.java.eventi;

public class Concerto extends Evento {
	
	//attributi proprio della classe Concerto
	private String oraLocale;
	private double prezzo;

	public Concerto(String titolo, String data, int postiTotali, int postiPrenotati, String oraLocale, double prezzo) {
		super(titolo, data, postiTotali, postiPrenotati);
		this.oraLocale = oraLocale;
		this.prezzo = prezzo;
	}

}
