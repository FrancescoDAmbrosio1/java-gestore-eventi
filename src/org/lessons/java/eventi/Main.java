package org.lessons.java.eventi;

import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		int scelta;
//		String titolo = null;
//		String data;
//		int postiTotali = 0;
//		int postiDaPrenotare;
//		int postiDaDisdire;
////		String oraLocale;
//		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("--------------------------------------------------");
//		System.out.println("---------------- GESTORE EVENTI ------------------");
//		System.out.println("--------------------------------------------------\n");
//		
////		Evento eventoConcerto = new Concerto(titolo, LocalDate.parse("2024-01-01"),postiTotali, 0, LocalTime.parse("10:15"), 0.0);
//		
//		do {
//			Evento.stampaMenu();
//			scelta = scan.nextInt();
//			switch(scelta) {
//				case 1:
//					Evento eventoCreato = new Evento(titolo, LocalDate.parse("2024-01-01"), postiTotali, 0);
//					System.out.println("Inserisci il titolo dell'evento: ");
//					//da problemi con stringhe formate da più parole
//					titolo =scan.next();
//					System.out.println("Inserisci data evento nel formato yyyy-mm-gg: ");
//					data = scan.next();
//					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
//					postiTotali = scan.nextInt();
//					eventoCreato.titolo = titolo;
//					eventoCreato.data = LocalDate.parse(data);
//					eventoCreato.postiTotali = postiTotali;
//					if(eventoCreato.setData(data)) {
//						do {
//							System.out.println("Inserisci nuova data evento nel formato yyyy-mm-gg: ");
//							data = scan.next();
//							eventoCreato.data = LocalDate.parse(data);
//							} while(eventoCreato.setData(data));
//					}
//					ProgrammEventi listaEventi = new ProgrammEventi(eventoCreato.titolo);
//					listaEventi.aggiungiEvento(eventoCreato);
//					System.out.println("Hai inserito il seguente evento: " + eventoCreato.toString());
//			
//					break;
//					
//				case 2:
//					
//					System.out.println("Indicare quanti posti vuoi prenotare per l'evento " + titolo + ": ");
//					postiDaPrenotare = scan.nextInt();
//					int i;
//					for(i = 0; i < postiDaPrenotare;i++) {
//						eventoCreato.prenota();						
//					}
//					System.out.println("Per l'evento " + eventoCreato.toString() + " sono stati prenotati n° "
//							+ " " + i + " posti.");
//					eventoCreato.resocontoPostiEvento();
//					break;
//				case 3:
//					System.out.println("Indicare quanti posti vuoi disdire per l'evento " + titolo + ": ");
//					postiDaDisdire = scan.nextInt();
//					int j;
//					for(j = 0; j < postiDaDisdire;j++) {
//						eventoCreato.disdici();
//					}
//					System.out.println("Per l'evento " + eventoCreato.toString() + " sono stati prenotati n° "
//							+ " " + j + " posti.");
//					eventoCreato.resocontoPostiEvento();
//					break;
//				case 4:
//					System.out.println(listaEventi.toString());
//					break;
//				case 5:
//				case 6:
//				case 7:
//					System.out.println("------ USCITA DAL GESTORE EVENTI ------");
//					break;
//					
//			}
//				
//		}while(scelta != 7);
//		

	}
	
	

}
