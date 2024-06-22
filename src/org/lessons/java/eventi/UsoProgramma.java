package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
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
		int postiDaPrenotare;
		String eventoSelezionato;
		int postiPrenotati;
		int postiDisponibili;
		
		// creato due scanner : uno per le stringhe ed uno per il resto.
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		LocalDate dataLocale = LocalDate.now(ZoneId.of("Europe/Rome"));

		Evento.header();
		
		titoloLista = "PROGRAMMAZIONE EVENTI";
		
			ProgrammEventi listaEventi = new ProgrammEventi(titoloLista);
		
			do {
				Evento.stampaMenu();
				System.out.print("\nInserisci la tua scelta:");
				scelta = scanInt.nextInt();
				switch(scelta) {
				case 1:
					System.out.print("\nInserisci il titolo dell'evento: ");
					titolo = scanString.nextLine();
					
					System.out.print("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scanString.nextLine();
					dataEvento = null;
					
					System.out.print("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scanInt.nextInt();
					
					Evento eventoCreato = new Evento(titolo, dataEvento, postiTotali, postiTotali);
					if(eventoCreato.verificaData(data, dataLocale)) {
						do {
							System.out.print("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scanString.nextLine();
							eventoCreato.data = LocalDate.parse(data);
							
						} while(LocalDate.parse(data).isBefore(dataLocale));
					} else {
						dataEvento = LocalDate.parse(data);
					}
					
					System.out.print("\n	Hai inserito il seguente evento: " + eventoCreato.toString() +
							"\n");
					
					listaEventi.aggiungiEvento(eventoCreato);
					break;
				
				case 2:
					System.out.print("\nInserisci il titolo del Concerto: ");
					titolo = scanString.nextLine();
					
					System.out.print("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scanString.nextLine();
					dataEvento = null;
					
					System.out.print("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scanInt.nextInt();
					
					System.out.print("Inserisci orario evento nel formato hh:mm : ");
					oraEvento = scanString.nextLine();
					
					System.out.print("Inserisci il prezzo del ticket per l'evento (##,##): ");
					prezzo = scanInt.nextDouble();
					
					Evento concertoCreato = new Concerto(titolo, dataEvento, postiTotali, 0, LocalTime.parse(oraEvento), prezzo);
					if(concertoCreato.verificaData(data, dataLocale)) {
						do {
							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scanString.nextLine();
							concertoCreato.data = LocalDate.parse(data);
						} while(LocalDate.parse(data).isBefore(dataLocale));
					} else {
						dataEvento = LocalDate.parse(data);
					} 
					System.out.print("\n	Hai inserito il seguente evento: " + concertoCreato.toString() +
							"\n");
					
					listaEventi.aggiungiEvento(concertoCreato);
					break;
					
				case 3:
					System.out.print(listaEventi.toString() + "\nInserire il titolo dell'evento scelto: \n");
					eventoSelezionato = scanString.nextLine();
					
					System.out.print("Indicare quanti posti vuoi prenotare per l'evento " + eventoSelezionato + ": ");
					postiDaPrenotare = scanInt.nextInt();
					
					Evento eventoPostiPren = listaEventi.eventoPosti(eventoSelezionato);
					postiPrenotati = 0;
					postiDisponibili = eventoPostiPren.calcoloPostiDisponibili();
					for(int j = 0; j < postiDaPrenotare;j++) {
							postiPrenotati = eventoPostiPren.prenota(postiDaPrenotare, postiDisponibili);	
					}
					eventoPostiPren.outputPrenotazione(eventoPostiPren.titolo, postiDaPrenotare);
					break;
				
				case 4:
					System.out.println(listaEventi.toString() + "\nInserire il titolo dell'evento scelto: \n");
					eventoSelezionato = scanString.nextLine();
					
					System.out.println("Indicare quanti posti vuoi disdire per l'evento " + eventoSelezionato + ": ");
					postiDaPrenotare = scanInt.nextInt();
					
					Evento eventoPostiDisd = listaEventi.eventoPosti(eventoSelezionato);
					int y;
					for(y = 0; y < postiDaPrenotare;y++) {
								eventoPostiDisd.disdici();					
						}
					
					System.out.println("Per l'evento " + eventoPostiDisd.toString() + " sono stati disdetti n° "
									+ " " + y + " posti.");
							eventoPostiDisd.resocontoPostiEvento();
					break;
					
				case 5:
					System.out.println("\nIn programmazione ci sono " + listaEventi.numeroEventiProgramma() + 
							" eventi.\n");
					System.out.println("LISTA eventi ordinati per data: " + listaEventi.listaOrdinataPerData());
					break;
					
				case 6:
					System.out.print("Inserisci la data di ricerca eventi (yyyy-mm-gg) :");
					String dataRicerca = scanString.nextLine();
					
					List<Evento> listaPerDataOutput = listaEventi.listaPerData(LocalDate.parse(dataRicerca));
					if(listaPerDataOutput.size() == 0) {
						System.out.println("\n -- Non sono presenti eventi per la data inserita. -- ");
					}else {
						System.out.println("\nEventi corrispondenti alla data " + dataRicerca +
								"\n" + listaPerDataOutput);						
					}
					break;
					
				case 7:
					System.out.println("\n********************** ATTENZIONE ***********************\n"
							   + "*   Hai scelto di cancellare l'intera lista eventi...   *\n"
							   + "*      l'operazione è IRREVERSIBILE. Sei sicuro?        *\n"
							   + "*********************************************************");
					System.out.print("\nInserisci la tua scelta [Si/No]:\n");
					String risposta = scanString.nextLine();
					listaEventi.svuotaElencoProgrammi(risposta);
					break;
				}
						
			} while (scelta != 8);
			Evento.footer();
			
	}

	
}



