package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UsoProgramma {

	public static void main(String[] args) {
		int scelta;
		String titolo = null;
		String data;
		String oraEvento;
		double prezzo;
		int postiTotali = 0;
		int postiDaPrenotare;
		int postiDaDisdire;
		Evento evento = null;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------");
		System.out.println("---------------- GESTORE EVENTI ------------------");
		System.out.println("--------------------------------------------------\n");
		
//		Evento eventoConcerto = new Concerto(titolo, LocalDate.parse("2024-01-01"),postiTotali, 0, LocalTime.parse("10:15"), 0.0);
		
		do {
			Evento.stampaMenu();
			scelta = scan.nextInt();
			switch(scelta) {
				case 1:
					System.out.println("Inserisci il titolo dell'evento: ");
					//da problemi con stringhe formate da più parole
					titolo =scan.next();
					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scan.next();
					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scan.nextInt();
					Evento eventoCreato = new Evento(titolo, LocalDate.parse(data), postiTotali, 0);
					if(eventoCreato.setData(data)) {
						do {
							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scan.next();
							eventoCreato.data = LocalDate.parse(data);
							} while(eventoCreato.setData(data));
					}
					ProgrammEventi listaEventi = new ProgrammEventi(eventoCreato.titolo);
					listaEventi.aggiungiEvento(eventoCreato);
					evento = eventoCreato;
					System.out.println("Hai inserito il seguente evento: " + eventoCreato.toString());
			
					break;
					
				case 2:
					System.out.println("Inserisci il titolo dell'evento: ");
					//da problemi con stringhe formate da più parole
					titolo =scan.next();
					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scan.next();
					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scan.nextInt();
					System.out.println("Inserisci orario evento nel formato hh:mm ");
					oraEvento = scan.next();
					System.out.println("Inserisci prezzo ticket evento (xx,xx): ");
					prezzo = scan.nextDouble();
					Evento concertoCreato = new Concerto(titolo, LocalDate.parse(data), postiTotali, 0,LocalTime.parse(oraEvento), prezzo);
					if(concertoCreato.setData(data)) {
						do {
							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scan.next();
							concertoCreato.data = LocalDate.parse(data);
							} while(concertoCreato.setData(data));
					}
					evento = concertoCreato;
					System.out.println("Hai inserito il seguente evento: " + concertoCreato.toString());
					break;
					
				case 3: 
					Evento.menuGestioneEvento();
					break;
					
				case 4:
					System.out.println("------ PASSA ALLA GESTIONE EVENTI ------");
					break;
					
			}
			ProgrammEventi listaEventi = new ProgrammEventi(titolo);
			listaEventi.aggiungiEvento(evento);	
		}while(scelta != 2);
		
		

	}
}


