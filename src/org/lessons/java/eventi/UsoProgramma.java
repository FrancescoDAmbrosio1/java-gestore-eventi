package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsoProgramma {

	public static void main(String[] args) {
		
		String titolo = null;
		String titoloLista;
		int scelta;
		String data;
		int postiTotali;
		LocalDate dataEvento;
		String oraEvento;
		double prezzo;
		
		
		Scanner scan = new Scanner(System.in);
		LocalDate dataLocale = LocalDate.now(ZoneId.of("Europe/Rome"));

		
		
		System.out.println("--------------------------------------------------");
		System.out.println("---------------- GESTORE EVENTI ------------------");
		System.out.println("--------------------------------------------------\n");
		
		titoloLista = "PROGRAMMAZIONE EVENTI";
		
			ProgrammEventi listaEventi = new ProgrammEventi(titoloLista);
		
			do {
				Evento.stampaMenu();
				scelta = scan.nextInt();
				switch(scelta) {
				case 1:
					System.out.println("Inserisci il titolo dell'evento: ");
					titolo = scan.next();
					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scan.next();
					if(Evento.setData(data, dataLocale)) {
						do {
							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scan.next();
							dataEvento = LocalDate.parse(data);
						} while(LocalDate.parse(data).isBefore(dataLocale));
					} else {
						dataEvento = LocalDate.parse(data);
					}
					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scan.nextInt();
					
					Evento eventoCreato = new Evento(titolo, dataEvento, postiTotali, postiTotali);
					
					System.out.println("Hai inserito il seguente evento: " + eventoCreato.toString());
					
					listaEventi.aggiungiEvento(eventoCreato);
					break;
				
				case 2:
					System.out.println("Inserisci il titolo del Concerto: ");
					titolo = scan.next();
					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scan.next();
					
					if(Evento.setData(data, dataLocale)) {
						do {
							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scan.next();
							dataEvento = LocalDate.parse(data);
						} while(LocalDate.parse(data).isBefore(dataLocale));
					} else {
						dataEvento = LocalDate.parse(data);
					}
					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scan.nextInt();
					System.out.println("Inserisci orario evento nel formato hh:mm : ");
					oraEvento = scan.next();
					System.out.println("Inserisci il prezzo del ticket per l'evento (##,##): ");
					prezzo = scan.nextDouble();
					
					Evento concertoCreato = new Concerto(titolo, dataEvento, postiTotali, 0, LocalTime.parse(oraEvento), prezzo);
					
					System.out.println("Hai inserito il seguente evento: " + concertoCreato.toString());
					
					listaEventi.aggiungiEvento(concertoCreato);
					break;
					
				}				
			} while (scelta != 7);
			
			System.out.println("LISTA: " + listaEventi.toString());
			
			
	}
}


