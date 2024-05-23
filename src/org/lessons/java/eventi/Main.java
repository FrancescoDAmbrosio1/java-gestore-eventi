package org.lessons.java.eventi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int scelta;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------");
		System.out.println("---------------- GESTORE EVENTI ------------------");
		System.out.println("--------------------------------------------------\n");
		do {
			stampaMenu();
			scelta = scan.nextInt();
			switch(scelta) {
				case 1:
					Evento evento1 = new Evento(null, null, 0, 0);
					System.out.println("Inserisci il titolo dell'evento: ");
					String titolo =scan.next();
					evento1.setTitolo(titolo);
					System.out.println("Inserisci l'anno dell'evento nel formato yyyy: ");
					int anno = scan.nextInt();
					System.out.println("Inserisci il mese dell'evento nel formato mm: ");
					int mese = scan.nextInt();
					System.out.println("Inserisci il giorno dell'evento nel formato gg: ");
					int giorno = scan.nextInt();
					evento1.setData(anno, mese, giorno);
					System.out.println("Inserisci i posti totali disponibili per l'evento: ");
					int postiTotali = scan.nextInt();
					evento1.getPostiTotali(postiTotali);
					System.out.println("Hai inserito il seguente evento: " + evento1.toString());
					
			}
				
		}while(scelta == 4);
		
		
		Evento evento1 = new Evento(null, null, 0, 0);

	}
	
	public static void stampaMenu() {
		System.out.println("Digitare il numero dell'attività da eseguire: \n"
				+ "[1] - Inserisci un nuovo evento\n"
				+ "[2] - Prenota posti\n"
				+ "[3] - Disdici posti\n"
				+ "[4] - Esci dal programma\n");
	}

}
