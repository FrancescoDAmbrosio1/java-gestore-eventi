package org.lessons.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int scelta;
		String titolo;
		String data;
		int postiTotali;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------");
		System.out.println("---------------- GESTORE EVENTI ------------------");
		System.out.println("--------------------------------------------------\n");
		do {
			stampaMenu();
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
					Evento evento1 = new Evento(titolo, LocalDate.parse(data), postiTotali, 0);
					System.out.println("Hai inserito il seguente evento: " + evento1.toString());
					break;
				case 2:
					
				case 3:
					
				case 4:
					System.out.println("------ USCITA DAL GESTORE EVENTI ------");
					break;
					
			}
				
		}while(scelta != 4);
		

	}
	
	public static void stampaMenu() {
		System.out.println("Digitare il numero dell'attività da eseguire: \n"
				+ "[1] - Inserisci un nuovo evento\n"
				+ "[2] - Prenota posti\n"
				+ "[3] - Disdici posti\n"
				+ "[4] - Esci dal programma\n");
	}

}
