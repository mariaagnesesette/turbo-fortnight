package com.generation.esercizio;

import java.util.Scanner;
	

public class GestioneSpesa {

	public static void main(String[] args) {

		int azione;
		int continua = 1;
		Scanner scanner = new Scanner(System.in);
		ArticoloSpesa[] lista = new ArticoloSpesa[20];
		int contatoreArticoli = 0;
		
		do {
			System.out.println("\n-----------------------------------------------------\n"
							+"Digitare il numero dell'azione che vorresti eseguire:\n"
							+"\n 1. Aggiungi un articolo alla lista"
							+"\n 2. Visualizza tutta la lista della spesa"
							+"\n 3. Cerca un articolo per nome"
							+"\n 4. Modifica la quantità di un articolo"
							+"\n 5. Aggiorna il prezzo di un articolo"
							+"\n 6. Applica uno sconto a un articolo"
							+"\n 7. Segna un articolo come acquistato"
							+"\n 8. Segna un articolo come ancora da acquistare"
							+"\n 9. Visualizza solo gli articoli ancora da acquistare"
							+"\n 10. Visualizza solo gli articoli già acquistati"
							+"\n 11. Visualizza il totale stimato della spesa"
							+"\n 12. Visualizza il totale degli articoli già acquistati"
							+"\n 13. Visualizza l’articolo più costoso della lista"
							+"\n 14. Elimina un articolo dalla lista"
							+"\n 15. Esci");
			azione = Integer.parseInt(scanner.nextLine());
			
			switch (azione) {
		
				case 1:
					ArticoloSpesa articolo = new ArticoloSpesa();
					
					System.out.println("\n===ARTICOLO N° "+(contatoreArticoli+1)+"===\n");
					System.out.print("Inserire nome prodotto: ");
					articolo.nome = scanner.nextLine();
					System.out.print("Inserire tipo prodotto: ");
					articolo.categoria = scanner.nextLine();
					
					do {
						System.out.print("Inserire prezzo prodotto: ");
						articolo.prezzoUnitario = Double.parseDouble(scanner.nextLine());
						if (articolo.prezzoUnitario <= 0) {
							System.out.println("Errore: ritenta sarai più fortunato\n");
						}
					} while (articolo.prezzoUnitario <= 0);
					
					
					do {
						System.out.print("Inserire quantità prodotto: ");
						articolo.quantita = Integer.parseInt(scanner.nextLine());
						if (articolo.quantita <= 0) {
							System.out.println("Errore: ritenta sarai più fortunato");
						}
					} while (articolo.quantita <= 0);
					
						
					articolo.acquistato = false;
					
					lista[contatoreArticoli] = articolo;
					contatoreArticoli++;
					
					break;
					
				case 2:
					
					for (int i = 0; i < contatoreArticoli; i++) {
						System.out.println("\n===ARTICOLO N° "+(i+1)+"===\n");
						System.out.println(lista[i].toString());
					}
					
					break;
					
				case 3:
					
					System.out.println("Quale Articolo vuoi controllare?");
					
					String rispostaUt = scanner.nextLine();
					
					for (int t = 0; t < contatoreArticoli; t++) {
						
						if (lista[t].nome.equalsIgnoreCase(rispostaUt)) {
							System.out.println("\n===ARTICOLO N° "+(t+1)+"===\n");
							System.out.println(lista[t].toString());
						}
					}
					
					
					break;
				
				case 4:
					
					System.out.println("di quale articolo vuoi modificare la quantità?");
					String cambio = scanner.nextLine();
					System.out.println("quanto vuoi aggiungere?");
					int nuovaQuantita = Integer.parseInt(scanner.nextLine());
					
					if (nuovaQuantita > 0) {
					
						for (int t = 0; t < contatoreArticoli; t++) {
						
							if (lista[t].nome.equalsIgnoreCase(cambio)) {
								System.out.println("\n===ARTICOLO N° "+(t+1)+"===\n");
								lista[t].aumentaQuantita(nuovaQuantita);
								lista[t].quantita += nuovaQuantita;
							}
						}
					} else {
						System.out.println("-----------------------------------------------------\nErrore: ritenta sarai più fortunato");
					}
					
					
					break;
					
				case 5:
					
					break;
					
				case 6:
					
					break;
					
				case 7:
					
					break;
					
				case 8:
					
					break;
					
				case 9:
					
					break;
					
				case 10:
					
					break;
					
				case 11:
					
					break;
					
				case 12:
					
					break;
				
				case 13:
					
					break;
					
				case 14:
					
					System.out.println("Quale articolo vuoi eliminare?");
					
					break;
					
				case 15:
					
					System.out.println("Grazie per aver usato cassa amica");
					continua = 0;
					break;
					
				default:
					System.out.println("-----------------------------------------------------\nErrore: azione non riconosciuta, ritenta");
					break;
			}
			
			
		} while (continua == 1);
		
		scanner.close();
	}
}

