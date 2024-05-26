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
					System.out.println("Inserisci il titolo dell'evento (Usare il simolo '_' al posto dello spazio) : ");
					titolo = scan.next();
					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scan.next();
					dataEvento = null;
					
					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scan.nextInt();
					
					Evento eventoCreato = new Evento(titolo, dataEvento, postiTotali, postiTotali);
					if(eventoCreato.verificaData(data, dataLocale)) {
						do {
							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scan.next();
							eventoCreato.data = LocalDate.parse(data);
							
						} while(LocalDate.parse(data).isBefore(dataLocale));
					} else 
					System.out.println("Hai inserito il seguente evento: " + eventoCreato.toString());
					
					listaEventi.aggiungiEvento(eventoCreato);
					break;
				
				case 2:
					System.out.println("Inserisci il titolo del Concerto (Usare il simolo '_' al posto dello spazio): ");
					titolo = scan.next();
					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
					data = scan.next();
					dataEvento = null;
					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
					postiTotali = scan.nextInt();
					System.out.println("Inserisci orario evento nel formato hh:mm : ");
					oraEvento = scan.next();
					System.out.println("Inserisci il prezzo del ticket per l'evento (##,##): ");
					prezzo = scan.nextDouble();
					
					Evento concertoCreato = new Concerto(titolo, dataEvento, postiTotali, 0, LocalTime.parse(oraEvento), prezzo);
					if(concertoCreato.verificaData(data, dataLocale)) {
						do {
							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
							data = scan.next();
							concertoCreato.data = LocalDate.parse(data);
						} while(LocalDate.parse(data).isBefore(dataLocale));
					} else {
						dataEvento = LocalDate.parse(data);
					} 
					System.out.println("Hai inserito il seguente evento: " + concertoCreato.toString());
					
					listaEventi.aggiungiEvento(concertoCreato);
					break;
					
				case 3:
					System.out.println(listaEventi.toString() + "\nInserire il titolo dell'evento scelto: \n");
					eventoSelezionato = scan.next();
					System.out.println("Indicare quanti posti vuoi prenotare per l'evento " + eventoSelezionato + ": ");
					postiDaPrenotare = scan.nextInt();
					Evento eventoPostiPren = listaEventi.eventoPosti(eventoSelezionato);
					int j;
					for(j = 0; j < postiDaPrenotare;j++) {
								eventoPostiPren.prenota();						
						}
					System.out.println("Per l'evento " + eventoPostiPren.toString() + " sono stati prenotati n° "
									+ " " + j + " posti.");
							eventoPostiPren.resocontoPostiEvento();
					break;
				
				case 4:
					System.out.println(listaEventi.toString() + "\nInserire il titolo dell'evento scelto: \n");
					eventoSelezionato = scan.next();
					System.out.println("Indicare quanti posti vuoi disdire per l'evento " + eventoSelezionato + ": ");
					postiDaPrenotare = scan.nextInt();
					Evento eventoPostiDisd = listaEventi.eventoPosti(eventoSelezionato);
					int y;
					for(y = 0; y < postiDaPrenotare;y++) {
								eventoPostiDisd.disdici();					
						}
					System.out.println("Per l'evento " + eventoPostiDisd.toString() + " sono stati prenotati n° "
									+ " " + y + " posti.");
							eventoPostiDisd.resocontoPostiEvento();
					break;
					
				case 5:
					System.out.println("In programmazione ci sono " + listaEventi.numeroEventiProgramma() + 
							" eventi in Programma.");
					System.out.println("LISTA: " + listaEventi.toString());
					break;
					
				case 6:
					System.out.println("Hai scelto di cancellare l'intera lista eventi..."
							+ "l'operazione è irreversibile. Sei sicuro? (si/no)");
					String risposta = scan.next();
					listaEventi.svuotaElencoProgrammi(risposta);
					break;
					
				case 7:
					System.out.println("Inserisci la data di ricerca eventi (yyyy-mm-gg) :");
					String dataRicerca = scan.next();
					
					List<Evento> listaPerDataOutput = listaEventi.listaPerData(LocalDate.parse(dataRicerca));
					System.out.println("Eventi corrispondenti alla data " + dataRicerca +
							"\n" + listaPerDataOutput);
					break;
				}
						
			} while (scelta != 8);
			System.out.println("LISTA: " + listaEventi.toString());
			
			
	}
}



