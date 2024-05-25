package org.lessons.java.eventi;

import java.time.LocalDate;
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
		
		
		Scanner scan = new Scanner(System.in);
		LocalDate dataLocale = LocalDate.now(ZoneId.of("Europe/Rome"));
		
		
		System.out.println("--------------------------------------------------");
		System.out.println("---------------- GESTORE EVENTI ------------------");
		System.out.println("--------------------------------------------------\n");
		
		titoloLista = "Eventi TOP";
		
			ProgrammEventi listaEventi = new ProgrammEventi(titoloLista);
		
			do {
				Evento.stampaMenu();
				scelta = scan.nextInt();
				if(scelta == 1) {
					System.out.println("Inserisci il titolo dell'evento: ");
					titolo = scan.next();
					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scan.next();
					if(LocalDate.parse(data).isBefore(dataLocale)) {
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
					
				}				
			} while (scelta != 7);
			
			System.out.println("LISTA: " + listaEventi.toString());
			
			
	}
}


